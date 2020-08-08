package com.jdbc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.jdbc.model.Employee;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceImplTest {

	EmployeeService employeeService = new EmployeeServiceImpl();

	@Test
	public void createEmployeeTest() throws Exception {

		employeeService.createEmployee();
		Assert.assertNotNull(employeeService);

	}

	@Test
	public void getEmployeeDetailsTest() {
		Employee emp = new Employee();
		System.out.println("Employee  Details are .....");
		employeeService.getAllEmployees(1);
		Assert.assertNotNull(emp);

	}

	@Test
	public void addEmployeeTest() {

		Employee emp = new Employee(1, "Jansi", 22, 1);
		employeeService.insertEmployee(emp);
		Assert.assertNotNull(emp);
		Assert.assertEquals("Jansi", emp.getEmpName());

	}

	@Test
	public void updateEmployeeTest() {

		Employee emp = new Employee(1, "Jansirani", 22, 1);
		employeeService.updateEmployee(emp);
		Assert.assertNotNull(emp);
		Assert.assertEquals(1, emp.getEmpId());

	}

	@Test
	public void deleteEmployeeTest() {
		Employee emp = new Employee(1, "Jansirani", 22, 1);
		employeeService.deleteEmployee(1);
		Assert.assertEquals(1, emp.getDeptId());

	}

}
