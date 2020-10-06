package com.rest.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rest.model.Department;
import com.rest.model.DepartmentList;
import com.rest.service.DepartmentService;


@RestController
public class DepartmentController {
	
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);  

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/listDept")
	public List<Department> getAllDepartment() {
				return departmentService.getAllDepartments();
	}

	@GetMapping("/listDept/{id}")
	public Department getDeptById(@PathVariable int id) {
		logger.info("From Department application departmentController getById");
		return departmentService.getDeptById(id);
	}

	@GetMapping("/dept")
	public DepartmentList getDepartments() {
		logger.info("From Department application departmentController getAllDepartment Details");
		List<Department> dept = departmentService.getAllDepartments();
		DepartmentList list = new DepartmentList();
		list.setDepartments(dept);
		return list;

	}  

	@PostMapping("/addDept")
	public Department addDepartment(@Valid @RequestBody Department department) {
		logger.info("From Department application departmentController addDepartment");
		departmentService.insertDepartment(department);
		return department;
	}

	@PutMapping("/updateDept/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable int id) {
		logger.info("From Department application departmentController updateDepartment");
		departmentService.updateDepartment(id, department);
		return department;
	}

	@DeleteMapping("/deleteDept/{id}")
	public String deleteDepartment(@PathVariable int id) {
	    logger.info("From Department application departmentController deleteById");
		departmentService.deleteDepartment(id);
		return "Record Deleted";

	}

	@GetMapping("/deptList/{id}")
	@HystrixCommand(fallbackMethod = "createFallBackMethod")
	public Department getByDepartmentId(@PathVariable int id) throws InterruptedException {
		Thread.sleep(3000);
		return departmentService.getDeptById(id);
	}

	public Department createFallBackMethod(@PathVariable int id) {
		return new Department(0, "Request fails. It takes long time to response");
	}

}
