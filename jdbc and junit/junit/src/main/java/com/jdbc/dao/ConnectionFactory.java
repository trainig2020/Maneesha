package com.jdbc.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/emp";
	public static final String USER = "root";
	public static final String PASS = "root";


	public static Connection getConnection() {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}
}

/*
 * public static void main(String[] args) { Connection connection =
 * connectionFactory.getConnection(); }
 */
