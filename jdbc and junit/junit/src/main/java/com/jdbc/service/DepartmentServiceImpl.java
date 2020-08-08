package com.jdbc.service;

import java.util.List;

import com.jdbc.dao.DepatmentDao;
import com.jdbc.dao.DepatmentDaoImpl;
import com.jdbc.model.Department;



public class DepartmentServiceImpl implements DepartmentService {

	DepatmentDao dao = new DepatmentDaoImpl();

	@Override
	public void createDepartment() throws Exception {

		dao.createDepartment();
	}

	@Override
	public boolean insertDepartment(Department dept) {
		return dao.insertDepartment(dept);
	}

	@Override
	public List<Department> getAllDepartments(Department dept) {
		
		return dao.getAllDepartments(dept);
	}

	@Override
	public boolean updateDepartment(Department dept) {
		return dao.updateDepartment(dept);
	}

	@Override
	public boolean deleteDepartment(int deptId) {
		return dao.deleteDepartment(deptId);
	}

}
