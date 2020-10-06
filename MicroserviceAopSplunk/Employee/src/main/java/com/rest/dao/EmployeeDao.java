package com.rest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	public List<Employee> findByDeptId(int deptId);

}
