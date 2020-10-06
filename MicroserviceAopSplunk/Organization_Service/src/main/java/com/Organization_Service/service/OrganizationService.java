package com.Organization_Service.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.Organization_Service.model.Department;
import com.Organization_Service.model.DepartmentList;
import com.Organization_Service.model.Employee;
import com.Organization_Service.model.EmployeeList;


@Service
public class OrganizationService {
	@Autowired
	private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(OrganizationService.class);
	
	
	public DepartmentList getAllDepartments(){
		logger.info("From organization service get all departments service");
		return  restTemplate.getForObject("http://department-service/dept", DepartmentList.class);
	}
	
	
	public EmployeeList getAllEmployees(){
		logger.info("From organization service get all employees service");
		return  restTemplate.getForObject("http://employee-service/emp", EmployeeList.class);
	}
	
	public Department getDepartmentById(int id) {
		logger.info("From organization service get department by id service");
		 return  restTemplate.getForObject("http://department-service/listDept/"+id, Department.class);
	}
	
	public Employee getEmployeeById(int id) {
		logger.info("From organization service get employee by id service");
		return  restTemplate.getForObject("http://employee-service/listEmp/"+id, Employee.class);
	}
	
	public Department insertDepartment(@Valid Department department) {
		logger.info("From organization service adding new department service");
		return restTemplate.postForObject("http://department-service/addDept", department, Department.class);
	}
	
	public Employee insertEmployee(Employee employee) {
		logger.info("From organization service adding new employee service");
		return restTemplate.postForObject("http://employee-service/addEmp", employee, Employee.class);
	}
	
	public void updateDepartment(int id ,Department department) {
		logger.info("From organization service update department service");
		   restTemplate.put("http://department-service/updateDept/"+id, department);
		 
	}
	
	public void updateEmployee(int id ,Employee employee) {
		logger.info("From organization service update employee service");
		 restTemplate.put("http://employee-service/updateEmp/"+id, employee);
	}
	
	
	public void deleteDepartment(int id) {
		logger.info("From organization service delete department service");
		restTemplate.delete("http://department-service/deleteDept/"+id);
	}
	
	public void deleteEmployee(int id) {
		logger.info("From organization service delete employee service");
		restTemplate.delete("http://employee-service/deleteEmp/"+id);
	}
	
	public EmployeeList getAllEmployeesByDeptId(int deptId){
		logger.info("From organization service get employees by department id service");
		return   restTemplate.getForObject("http://employee-service/empList/"+deptId, EmployeeList.class);
	}
	

}
