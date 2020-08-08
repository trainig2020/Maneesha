package com.demo.service;

import java.util.List;

import com.demo.dao.DepatmentDao;
import com.demo.dao.DepatmentDaoImpl;
import com.demo.model.Department;

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
