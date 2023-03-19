package com.techelevator.projects.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {


		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {
		Project project = null;
		String sql = "SELECT * FROM project WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		if (results.next()){
			project = mapRowToProject(results);
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		//Project project = new Project();
		String sql = " SELECT * FROM project";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		List<Project> projects = new ArrayList<>();
		while(results.next()) {
			Project proj = mapRowToProject(results);
			projects.add(proj);

		}
		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
//		newProject.setName("project");
//		newProject.setToDate(LocalDate.parse("1998-09-11"));
//		newProject.setFromDate(LocalDate.parse("1998-12-19"));

		String createProjectSql = "INSERT INTO  project (name, to_date, from_date) VALUES (?,?,?) RETURNING project_id;";

		int project_id = jdbcTemplate.queryForObject(createProjectSql, int.class, newProject.getName(), newProject.getToDate(), newProject.getFromDate());
		//createProjectSql, newProject.getId(), newProject.getName(), newProject.getFromDate(), newProject.getToDate();
		 newProject.setId(project_id);

		return newProject;
	}

	@Override
	public void deleteProject(int projectId) {
		String deletedEmployeeSql = "DELETE FROM project_employee WHERE employee_id = ?";
		int numberOfEmployeeRowsDeleted = jdbcTemplate.update(deletedEmployeeSql, projectId);
		System.out.println(numberOfEmployeeRowsDeleted);

		String deleteProjectSql = "DELETE FROM project WHERE project_id= ?;";
		int numberOfRowsDeleted= jdbcTemplate.update(deleteProjectSql, projectId);
		System.out.println(numberOfRowsDeleted);


	}

	private Project mapRowToProject(SqlRowSet results){
		Project proj = new Project();
		proj.setId(results.getInt("project_id"));
		proj.setName(results.getString("name"));
		if((results.getDate("from_date")) != null){
			proj.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if((results.getDate("to_date")) != null){
			proj.setToDate(results.getDate("to_date").toLocalDate());
		}

	return  proj;}
	

}
