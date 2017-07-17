package com.project.registration;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Database {

	public Connection getConnection() throws Exception {
		try {
			String connectionURL = "jdbc:mysql://127.0.0.1:3306/registration";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = (Connection) DriverManager.getConnection(connectionURL, "root", "root");
			return connection;
		} catch (Exception e) {
			throw e;
		}
	}

}
