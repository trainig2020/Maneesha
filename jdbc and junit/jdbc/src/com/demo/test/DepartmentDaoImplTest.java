package com.demo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.demo.dao.DepatmentDao;
import com.demo.dao.DepatmentDaoImpl;
import com.demo.model.Department;

class DepartmentDaoImplTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	DepatmentDao departmentDao = new DepatmentDaoImpl();

	@Test
	public void addDepartmentTest(Department dept) {

	
		
		departmentDao.insertDepartment(dept);
		
		Assert.assertNotNull(dept);
		

	}

}
