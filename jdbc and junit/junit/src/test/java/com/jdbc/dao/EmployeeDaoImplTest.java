package com.jdbc.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.jdbc.model.Employee;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeDaoImplTest {

	EmployeeDao dao = new EmployeeDaoImpl();

	@Test
	public void createEmployeeTest() throws Exception {

		dao.createEmployee();
		Assert.assertNotNull(dao);

	}

	@Test
	public void readEmployeesTest() {

		dao.getAllEmployees(1);
		Assert.assertNotNull(dao);

	}

	@Test
	public void addEmployeeTest(Employee emp) {

		dao.insertEmployee(emp);
		Assert.assertNotNull(emp);

	}
	
	@Test
	public void updateEmployeeTest(Employee emp) {

		dao.updateEmployee(emp);
		Assert.assertNotNull(emp);

	}

	@Test
	public void deleteEmployeeTest() {

		dao.deleteEmployee(1);

	}

}
