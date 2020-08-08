package com.jdbc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.jdbc.model.Department;


@RunWith(MockitoJUnitRunner.Silent.class)
public class DepartmentServiceImplTest {

	DepartmentService deptService = new DepartmentServiceImpl();
	

	@Test
	public void createDepartmentTest() throws Exception {

		deptService.createDepartment();

	}

	@Test
	public void addDepartmentTest() {

		Department dept = new Department(13, "Physics");
		deptService.insertDepartment(dept);
		Assert.assertNotNull(dept);
		Assert.assertEquals("physics", dept.getDeptName());

	}

	@Test
	public void getAllDepartmentTest() {
		Department dept = new Department();
		System.out.println("Department Details");
		deptService.getAllDepartments(dept);
		Assert.assertNotNull(dept);

	}

	@Test
	public void updateDepartmentTest() {

		Department dept = new Department(13, "chemistry");
		deptService.updateDepartment(dept);
		Assert.assertNotNull(dept);
		Assert.assertEquals(13, dept.getDeptId());

	}

	@Test
	public void deleteDepartmentTest() {
		Department dept = new Department(13, "chemistry");
		deptService.deleteDepartment(13);
		Assert.assertEquals(13, dept.getDeptId());

	}
}
