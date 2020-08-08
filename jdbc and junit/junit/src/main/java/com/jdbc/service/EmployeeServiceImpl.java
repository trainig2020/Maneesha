package com.jdbc.service;

import java.util.List;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.EmployeeDaoImpl;
import com.jdbc.model.Employee;


public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public void createEmployee() throws Exception {
		dao.createEmployee();

	}

	@Override
	public boolean insertEmployee(Employee emp) {
		return dao.insertEmployee(emp);
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		return dao.updateEmployee(emp);
	}

	@Override
	public boolean deleteEmployee(int deptId) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(deptId);
	}

	@Override
	public List<Employee> getAllEmployees(int deptId) {

		return dao.getAllEmployees(deptId);
	}

}
