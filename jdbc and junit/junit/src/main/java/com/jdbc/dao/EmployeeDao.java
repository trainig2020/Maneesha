package com.jdbc.dao;

import java.util.List;

import com.jdbc.model.Employee;


public interface EmployeeDao {

	public void createEmployee() throws Exception;

	public boolean insertEmployee(Employee emp);

	public boolean updateEmployee(Employee emp);

	public boolean deleteEmployee(int deptId);

	public List<Employee> getAllEmployees(int deptId);

}
