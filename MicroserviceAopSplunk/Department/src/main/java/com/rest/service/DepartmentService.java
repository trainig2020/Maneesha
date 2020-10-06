package com.rest.service;

import java.util.List;

import com.rest.model.Department;


public interface DepartmentService {
	
	public Department insertDepartment(Department dept);
	public List<Department> getAllDepartments();
	public Department updateDepartment(int id,Department dept);
	public void deleteDepartment(int deptId);
	public Department getDeptById(int deptId);



}
