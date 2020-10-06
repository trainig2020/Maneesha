package com.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.model.Employee;
import com.rest.model.EmployeeList;
import com.rest.service.EmployeeService;


@RestController
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/listEmp")
	public List<Employee> getAllEmployees() {
		logger.info("From Employee application employee controller get all employees");
		return employeeService.getAllEmployees();
	}

	@GetMapping("/emp")
	public EmployeeList getEmployees() {
		List<Employee> emp = employeeService.getAllEmployees();
		EmployeeList list = new EmployeeList();
		list.setEmployees(emp);
		return list;

	}

	@GetMapping("/listEmp/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		logger.info("From Employee application employee controller get employees by id");
		return employeeService.getEmployees(id);
	}

	@GetMapping("emp/{deptId}")
	public List<Employee> getEmployeeByDeptId(@PathVariable int deptId) {
		logger.info("From Employee application employee controller get employees by department id");
		return employeeService.getEmployeesByDept(deptId);
	}

	@GetMapping("empList/{deptId}")
	public EmployeeList getEmpByDeptId(@PathVariable int deptId) {
		logger.info("From Employee application employee controller get employees by department id");
		List<Employee> emp = employeeService.getEmployeesByDept(deptId);
		EmployeeList list = new EmployeeList();
		list.setEmployees(emp);
		return list;
	}

	@PostMapping("/addEmp")
	public Employee addEmployee(@RequestBody Employee employee) {
		logger.info("From Employee application employee controller adding new employee");
		employeeService.insertEmployee(employee);
		return employee;
	}

	@PutMapping("/updateEmp/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		logger.info("From Employee application employee controller updating employee records");
		employeeService.updateEmployee(id, employee);
		return employee;
	}

	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		logger.info("From Employee application employee controller deleting employee");
		employeeService.deleteEmployee(id);
		return "Record Deleted";

	}

}
