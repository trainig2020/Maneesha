package com.jdbc.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.jdbc.model.Department;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DepartmentDaoImplTest {

	DepatmentDao departmentDao = new DepatmentDaoImpl();


	@Test
	public void createDepartmentTest() throws Exception {

		departmentDao.createDepartment();

	}

	@Test
	public void addDepartmentTest(Department dept) {

		departmentDao.insertDepartment(dept);
		Assert.assertNotNull(dept);

	}

	@Test
	public void getAllDepartmentsTest(Department dept) {

		departmentDao.getAllDepartments(dept);
		Assert.assertNotNull(dept);

	}

	@Test
	public void updateDepartmentTest(Department dept) {

		departmentDao.updateDepartment(dept);
		Assert.assertNotNull(dept);

	}

	@Test
	public void deleteDepartmentTest(int deptId) {

		departmentDao.deleteDepartment(13);

	}

}
