package com.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Department;


@Repository
public interface DepartmentDao extends CrudRepository<Department, Integer> {

}
