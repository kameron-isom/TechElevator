package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(int id) {
		Department dept = null;
		String sql = "SELECT department_id, name FROM department WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if(results.next()){
			 dept = mapRowToDepartment(results);
//			 id = results.getInt(id);
			return dept;
		}
		return null;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = "SELECT department_id, name FROM department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		var depts = new ArrayList<Department>();
		while(results.next()){
			Department dept = mapRowToDepartment(results);
			depts.add(dept);
		}

		return depts;
		//return new ArrayList<>()


	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sql = "UPDATE department SET name=? WHERE department_id = ?";
		int updatedRows = jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());
		if(updatedRows != 1){
			System.out.println("Failed to update department");
		}
	}

	private Department mapRowToDepartment(SqlRowSet results){
		Department dept = new Department();
		dept.setId(results.getInt("department_id"));
		dept.setName(results.getString("name"));
		return dept;
	}

}
