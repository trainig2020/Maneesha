package com.Organization_Service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.Organization_Service.model.Department;
import com.Organization_Service.service.OrganizationService;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentTest {
	
	@Mock
    private RestTemplate restTemplate;
	
	@InjectMocks
	private OrganizationService organizationService;
	
	@Test
	public void getDepartment() {
		Department dept = new Department(1, "Admin");
		Mockito.when(restTemplate.getForObject("http://department-service/listDept/1", Department.class))
		 .thenReturn(dept);
		Department dept1 = organizationService.getDepartmentById(1);
		Assert.assertEquals(dept1, dept);
		
	}
	
	@Test
	public void deleteDepartment() {
		Department dept = new Department(5, "Research");
		Assert.assertEquals(5, dept.getDeptId());
		organizationService.deleteDepartment(5);
		
	}
	

}
