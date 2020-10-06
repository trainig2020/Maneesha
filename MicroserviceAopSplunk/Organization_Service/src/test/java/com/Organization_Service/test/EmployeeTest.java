package com.Organization_Service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.Organization_Service.model.Employee;
import com.Organization_Service.service.OrganizationService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {
	
	@Mock
    private RestTemplate restTemplate;
	
	@InjectMocks
	private OrganizationService organizationService;
	
	@Test
	public void getEmployee() {
		Employee emp = new Employee(1, "Ezhilarasi", 23, 1);
		Mockito.when(restTemplate.getForObject("http://employee-service/listEmp/1", Employee.class))
				.thenReturn(emp);
		Employee employee = organizationService.getEmployeeById(1);
		Assert.assertEquals(employee, emp);
		 
	}
	
	@Test
	public void deleteEmployee() {
		Employee emp = new Employee(5, "suja", 22, 2);
		Assert.assertEquals(5, emp.getEmpId());
		organizationService.deleteEmployee(5);
	}

}
