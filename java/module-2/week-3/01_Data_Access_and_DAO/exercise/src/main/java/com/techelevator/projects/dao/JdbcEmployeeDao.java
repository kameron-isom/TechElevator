package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> emps =  new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()){
			emps.add(mapRowToEmployee(results));
		}

		return emps;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> emps =  new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");

		while (results.next()){
			emps.add(mapRowToEmployee(results));
		}

		return emps;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		ArrayList<Employee> emps =  new ArrayList<>();
		String sql = "SELECT em.employee_id, em.department_id, em.first_name, em.last_name, em.birth_date, em.hire_date FROM employee em JOIN project_employee pe ON em.employee_id = pe.employee_id WHERE pe.project_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		while (results.next()){
			emps.add(mapRowToEmployee(results));
		}

		return emps;

	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {
		List<Employee> project = new ArrayList<>();
		Employee employee = new Employee();

		String addEmployeeSql ="INSERT INTO project (project_id) VALUES((SELECT employee_id FROM project_employee WHERE employee_id =?),?)";
		SqlRowSet employeeToProjectResults= jdbcTemplate.queryForRowSet(addEmployeeSql, employeeId,  projectId);
		while ((employeeToProjectResults.next())){



		}

	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
		String removeProjectEmployeeSql = "DELETE FROM project_employee WHERE employee_id= ?";
		int numberOfRowsDeleted = jdbcTemplate.update(removeProjectEmployeeSql,employeeId);


		String removeEmployeeSql = "DELETE FROM employee WHERE employee_id =?";
		numberOfRowsDeleted = jdbcTemplate.update(removeEmployeeSql, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employeeWithoutProjects = new ArrayList<>();
		String sql= "SELECT employee_id FROM project_employee WHERE project_id IS NULL ";

		SqlRowSet results= jdbcTemplate.queryForRowSet(sql);
		while ((results.next())){
			Employee employee = mapRowToEmployee(results);
			employeeWithoutProjects.add(employee);
		}
		return employeeWithoutProjects;
	}

private Employee mapRowToEmployee(SqlRowSet results) {
	Employee emp = new Employee();
	emp.setId(results.getInt("employee_id"));
	emp.setDepartmentId(results.getInt("department_id"));
	emp.setFirstName(results.getString("first_name"));
	emp.setLastName(results.getString("last_name"));
	if (results.getDate("birth_date") != null) {
		emp.setBirthDate(results.getDate("birth_date").toLocalDate());
	}
	if (results.getDate("hire_date") != null) {
		emp.setHireDate(results.getDate("hire_date").toLocalDate());
	}
	return emp;
}
}
