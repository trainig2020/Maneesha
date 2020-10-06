package com.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.dao.EmployeeDao;
import com.rest.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee emp) {
		logger.info("From Employee application employee service creating new  employees");
		employeeDao.save(emp);

	}

	@Override
	public Employee updateEmployee(int empid, Employee emp) {
		logger.info("From Employee application employee service updating employees");
		return employeeDao.save(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		logger.info("From Employee application employee service deleting employees");
		employeeDao.deleteById(id);

	}

	@Override
	public Employee getEmployees(int empId) {
		logger.info("From Employee application employee service get employees by id");
		return employeeDao.findById(empId).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		logger.info("From Employee application employee service get all  employees");
		return (List<Employee>) employeeDao.findAll();
	}

	@Override
	public List<Employee> getEmployeesByDept(int deptId) {
		logger.info("From Employee application employee service get employee details by department id");
		return employeeDao.findByDeptId(deptId);
	}

}
