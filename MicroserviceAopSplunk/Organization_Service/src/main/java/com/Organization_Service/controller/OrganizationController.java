package com.Organization_Service.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Organization_Service.model.Department;
import com.Organization_Service.model.DepartmentList;
import com.Organization_Service.model.Employee;
import com.Organization_Service.model.EmployeeList;
import com.Organization_Service.service.OrganizationService;



@RestController
@RequestMapping("/organize")
public class OrganizationController {
	
	Logger logger = LoggerFactory.getLogger(OrganizationController.class);
	
	
	
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping("listDept")
	public DepartmentList getAllDepartments(){
		logger.info("From organization service application organization controller get all department details");
		return organizationService.getAllDepartments();
	}
	
	@GetMapping("listEmp")
	public EmployeeList getAllEmployees(){
		logger.info("From organization service application organization controller get all employees details");
		return organizationService.getAllEmployees();
	}
	
	@GetMapping("listDept/{id}")
	public Department getDepartmentById(@PathVariable int id) {
		logger.info("From organization service application organization controller get department by id");
		return organizationService.getDepartmentById(id);
	}
	
	@GetMapping("listEmp/{empid}")
	public Employee getEmployeeById(@PathVariable int empid) {
		logger.info("From organization service application organization controller get employee by id details");
		return organizationService.getEmployeeById(empid);
	}
	
	
	
	@PostMapping("/addDept")
	public Department addDepartment(@Valid @RequestBody Department department) {

		logger.info("From organization service application organization controller adding new department");
		return organizationService.insertDepartment(department);
	}
	
	@PostMapping("/addEmp")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		logger.info("From organization service application organization controller adding new employee");
		return organizationService.insertEmployee(employee);
	}
	
	@PutMapping("/updateDept/{id}")
	public String updateDepartment(@RequestBody Department department, @PathVariable int id) {
		
		logger.info("From organization service application organization controller updating department");
		 organizationService.updateDepartment(id, department);
		 return "Record Updated";
	}
	
	@PutMapping("/updateEmp/{empid}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable int empid) {
		
		logger.info("From organization service application organization controller updating employee details");
		 organizationService.updateEmployee(empid, employee);
		 return "Record Updated";
	}
	
	@DeleteMapping("/deleteDept/{id}")
	public String deleteDepartment(@PathVariable int id) {
		
		logger.info("From organization service application organization controller delete department");
		organizationService.deleteDepartment(id);
		return "Record deleted";
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		logger.info("From organization service application organization controller delete employee");
		organizationService.deleteEmployee(id);
		return "Record deleted";
	}
	
	@GetMapping("/emp/{deptId}")
	public EmployeeList getEmployeeByDeptId(@PathVariable int deptId) {
		logger.info("From organization service application organization controller get employee by id");
		return organizationService.getAllEmployeesByDeptId(deptId);
	}

}
