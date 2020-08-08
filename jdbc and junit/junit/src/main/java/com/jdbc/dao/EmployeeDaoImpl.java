package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.Employee;



public class EmployeeDaoImpl implements EmployeeDao {
	Connection con = ConnectionFactory.getConnection();

	@Override
	public void createEmployee() throws Exception {

		String sql = "create table employee(empId int(10) not null primary key,empName varchar(20) not null,age int(10) not null,"
				+ "deptId int(10) not null ,foreign key(deptId) references department(deptId))";

		Statement stmt = con.createStatement();

		stmt.execute(sql);

		System.out.println("Table created");
		stmt.close();

	}

	@Override
	public boolean insertEmployee(Employee emp) {

		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES ( ?, ?,?,?)");
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getEmpName());
			ps.setInt(3, emp.getAge());
			ps.setInt(4, emp.getDeptId());
			int i = ps.executeUpdate();
			if (i == 1) {
				System.out.println("Values are inserted into employee table");
				return true;
			}
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Values are not inserted into employee table");
		return false;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE employee SET empName=?,age=?,deptId=? WHERE empId=?");
			ps.setString(1, emp.getEmpName());
			ps.setInt(2, emp.getAge());
			ps.setInt(3, emp.getDeptId());
			ps.setInt(4, emp.getEmpId());
			int i = ps.executeUpdate();
			if (i == 1) {
				System.out.println("Employee name is updated");
				return true;
			}
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Employee name is not updated");
		return false;
	}

	public boolean deleteEmployee(int deptId) {

		try {
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("DELETE FROM employee WHERE deptId="+deptId);
			if (i >= 1) {
				System.out.println("Employee details are deleted");
				return true;
			}
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Employee details are not deleted");
		return false;
	}

	@Override
	public List<Employee> getAllEmployees(int deptId) {

		String query = "SELECT * FROM employee where deptId=?";

		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, deptId);
			ResultSet rs = stmt.executeQuery();
			List<Employee> emp = new ArrayList<Employee>();
			while (rs.next()) {
				System.out.println("empId :" + rs.getInt(1) + " empName :" + rs.getString(2) + " age :" + rs.getInt(3)
						+ " deptId: " + rs.getInt(4));

			}
			stmt.close();
			return emp;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
