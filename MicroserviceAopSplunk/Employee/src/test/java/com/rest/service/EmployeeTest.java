package com.rest.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rest.dao.EmployeeDao;
import com.rest.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {

	@Autowired
	private EmployeeService employeeService;

	@Mock
	private EmployeeDao empDao;

	@Test
	public void addEmployeeTest() {

		Employee employee = new Employee(1, "Jansi", 22, 2);
		employeeService.insertEmployee(employee);
		Assert.assertNotNull(employee);
		Assert.assertEquals("Jansi", employee.getEmpName());

	}

	@Test
	public void updateEmployeeTest() {

		Employee employee = new Employee(2, "Jenni", 21, 1);
		employeeService.updateEmployee(2, employee);
		Assert.assertNotNull(employee);
		Assert.assertEquals("Jenni", employee.getEmpName());

	}

	@Test
	public void deleteEmployeeTest() {
		Employee employee = new Employee();
		employee.setEmpId(3);
		
		employeeService.deleteEmployee(3);
		Assert.assertNotNull(employee);

	}

	@Test
	public void getAllEmployeeTest() {

		List<Employee> emp = new ArrayList<Employee>();
		Employee emp1 = new Employee(1, "Jansi", 21, 1);
		Employee emp2 = new Employee(2, "Jenni", 22, 2);
		emp.add(emp1);
		emp.add(emp2);
		Mockito.when(empDao.findAll()).thenReturn(emp);
		List<Employee> list = employeeService.getAllEmployees();
		Assert.assertEquals(4, list.size());

	}

}
