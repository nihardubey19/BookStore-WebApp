package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore-webapp", "BookStore-WebApp", "BookStore-WebApp");
			System.out.println("DB Successfully Connected!");
		}
		catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
