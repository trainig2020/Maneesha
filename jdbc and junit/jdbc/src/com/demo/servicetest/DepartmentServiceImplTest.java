package com.demo.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Test;
import com.demo.model.Department;
import com.demo.service.DepartmentService;
import com.demo.service.DepartmentServiceImpl;

class DepartmentServiceImplTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	DepartmentService deptService=new DepartmentServiceImpl();
	
	
	@Test
	public void addDepartmentTest() {
		
		Department dept=new Department(15,"Pharma");
		deptService.insertDepartment(dept);
		Assert.assertNotNull(dept);
		Assert.assertNotEquals("Pharma", dept.getDeptName());
		
	}

}
