package com.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.dao.DepartmentDao;
import com.rest.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Department insertDepartment(Department dept) {
		logger.info("From Department application department Service insert department");
		return departmentDao.save(dept);

	}

	@Override
	public List<Department> getAllDepartments() {

		logger.info("From Department application department Service get all department details");
		return (List<Department>) departmentDao.findAll();
	}

	@Override
	public Department updateDepartment(int id, Department dept) {
		logger.info("From Department application department Service update department");
		return departmentDao.save(dept);
	}

	@Override
	public void deleteDepartment(int deptId) {

		logger.info("From Department application department Service delete department by id");
		departmentDao.deleteById(deptId);

	}

	@Override
	public Department getDeptById(int deptId) {
		logger.info("From Department application department Service get department by id");
		return departmentDao.findById(deptId).get();
	}

}
