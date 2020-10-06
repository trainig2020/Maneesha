package com.DeptEmpUI.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;
import com.DeptEmpUI.model.Employee;
import com.DeptEmpUI.model.EmployeeList;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Mock
	private RestTemplate restTemplate;

	@MockBean
	private EmployeeController empController;

	@Autowired
	private MockMvc mockMvc;

	ObjectMapper map = new ObjectMapper();

	@Test
	public void createEmployeeTest() throws Exception {
		Employee emp = new Employee(1, "Jansi", 22, 1);

		Mockito.when(restTemplate.postForObject("http://dept-emp-service/organize/addEmp", emp, Employee.class))

				.thenReturn(emp);
		String json = map.writeValueAsString(emp);

		mockMvc.perform(post("/saveEmp").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

	@Test
	public void updateEmployeeTest() throws Exception {
		Employee emp = new Employee(1, "Jansi", 22, 1);
		int empId = emp.getEmpId();

		Mockito.when(restTemplate.getForObject("http://dept-emp-service/organize/updateEmp/" + empId, Employee.class))
		.thenReturn(emp);

		String json = map.writeValueAsString(emp);

		mockMvc.perform(post("/updateEmp").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		Assert.assertEquals(1, emp.getEmpId());
	}

	@Test
	public void deleteEmployeeTest() throws Exception {
		Employee emp = new Employee(1, "Jansi", 22, 1);
		int empId = emp.getEmpId();

		Mockito.when(restTemplate.getForObject("http://dept-emp-service/organize/deleteEmp/" + empId, Employee.class))
		.thenReturn(emp);

		String json = map.writeValueAsString(emp);

		mockMvc.perform(get("/deleteEmp").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());

	}
	
	@Test
	public void getAllEmployeesTest() throws Exception {
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(1, "Jansi", 22, 1));
		emp.add(new Employee(2, "Jenni", 18, 2));
		
		EmployeeList lst = new EmployeeList();
		lst.setEmployees(emp);
		
		Mockito.when(restTemplate.getForObject("http://dept-emp-service/organize/emp/1", EmployeeList.class))
		.thenReturn(lst);
		String req = map.writeValueAsString(lst);
		mockMvc.perform(
		MockMvcRequestBuilders.get("/listDeptName").content(req).contentType(MediaType.APPLICATION_JSON_VALUE));
		Assert.assertEquals(2, lst.getEmployees().size());
	}


}
