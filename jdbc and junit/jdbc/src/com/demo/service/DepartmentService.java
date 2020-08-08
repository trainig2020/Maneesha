package com.demo.service;

import java.util.List;

import com.demo.model.Department;

public interface DepartmentService {
	
	public void createDepartment() throws Exception;
	
	public boolean insertDepartment(Department dept);
	public List<Department> getAllDepartments(Department dept);
	public boolean updateDepartment(Department dept);
	public boolean deleteDepartment(int deptId);

}
