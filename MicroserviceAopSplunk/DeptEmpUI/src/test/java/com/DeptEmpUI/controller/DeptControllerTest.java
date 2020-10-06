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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;
import com.DeptEmpUI.model.Department;
import com.DeptEmpUI.model.DepartmentList;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(DeptController.class)
public class DeptControllerTest {

	@Mock
	private RestTemplate restTemplate;

	@MockBean
	private DeptController deptController;

	@Autowired
	private MockMvc mockMvc;

	ObjectMapper map = new ObjectMapper();

	@Test
	public void createDepartmentTest() throws Exception {
		Department dept = new Department(1, "CSE");

		Mockito.when(restTemplate.postForObject("http://dept-emp-service/organize/addDept", dept, Department.class))

				.thenReturn(dept);
		String json = map.writeValueAsString(dept);

		mockMvc.perform(MockMvcRequestBuilders.post("/saveDept").content(json))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void updateDepartmentTest() throws Exception {
		Department dept = new Department(1, "CSE");
		int deptId = dept.getDeptId();

		Mockito.when(
				restTemplate.getForObject("http://dept-emp-service/organize/updateDept/" + deptId, Department.class))
		.thenReturn(dept);

		String json = map.writeValueAsString(dept);

		mockMvc.perform(post("/updateDept").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		Assert.assertEquals(1, dept.getDeptId());
	}

	@Test
	public void deleteDepartmentTest() throws Exception {
		Department dept = new Department(1, "CSE");
		int deptId = dept.getDeptId();

		Mockito.when(
				restTemplate.getForObject("http://dept-emp-service/organize/deleteDept/" + deptId, Department.class))
		.thenReturn(dept);

		String json = map.writeValueAsString(dept);

		mockMvc.perform(get("/deleteDept").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());

	}

	@Test
	public void getAllDepartmentTest() throws Exception {
		List<Department> dep = new ArrayList<Department>();
		Department dept = new Department(1, "CSE");
		Department dept1 = new Department(2, "Mech");
		dep.add(dept1);
		dep.add(dept);

		Mockito.when(restTemplate.getForObject("http://dept-emp-service/organize/listDept", DepartmentList.class))
				.thenReturn(Mockito.any());

		String json = map.writeValueAsString(dep);

		mockMvc.perform(get("/listDept").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());

	}

}
