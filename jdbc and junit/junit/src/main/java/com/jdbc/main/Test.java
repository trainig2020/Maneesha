package com.jdbc.main;

import com.jdbc.model.Department;
import com.jdbc.model.Employee;
import com.jdbc.service.DepartmentService;
import com.jdbc.service.DepartmentServiceImpl;
import com.jdbc.service.EmployeeService;
import com.jdbc.service.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) throws Exception {

		DepartmentService deptService = new DepartmentServiceImpl();
		Department dept = new Department(17, "Cse");

		// create Database
		  //deptService.createDepartment();

		// Insert values into department
		if (deptService.insertDepartment(dept)) {
			System.out.println("Department values are inserted");
		} else {
			System.out.println("Error");
		}  

		// Get all department details
		System.out.println("Department Details");
		deptService.getAllDepartments(dept);    

		// updating Department Name
		Department dept1 = new Department();
		dept1.setDeptName("MECH");
		dept1.setDeptId(8);
		if (deptService.updateDepartment(dept1)) {
			System.out.println("Department Name is updated");

		} else {
			System.out.println("Department Name is not updated");
		}  

		// Delete Department Based on Id

		if (deptService.deleteDepartment(9)) {
			System.out.println("Department is deleted");
		} else {
			System.out.println(" given deptId not found ");
		}  

		// Employee table creation

		EmployeeService empService = new EmployeeServiceImpl();

		//empService.createEmployee();  

		// Inserting Employees

		Employee emp = new Employee(11, "sumathi", 20, 8);

		if (empService.insertEmployee(emp)) {
			System.out.println("Employee values are inserted");
		} else {
			System.out.println("Employee values are not inserted");
		}   

		// Updating Employee

		Employee emp1 = new Employee(1, "srikanth", 20, 6);

		if (empService.updateEmployee(emp1)) {
			System.out.println("Employee values updated");
		} else {
			System.out.println("Employee values not updated");
		}   

		// Deleting Employee
		
		if (empService.deleteEmployee(5)) {
			System.out.println("Employees record deleted ");
		} else {
			System.out.println("Employee records not found for given id ");
		}

	// get all employees based on department id
        System.out.println("Employee details are.....");
		if (empService.getAllEmployees(6) != null) {
			System.out.println("End of Employees records");
		} else {
			System.out.println("No records found for the given id");
		}  

	}  

}
