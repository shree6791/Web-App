package com.shree.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public TestConnection() {
	}

	public static void main(String[] args) {

		System.out.println("Hello World");

		String jdbcUrl = "jdbc:mysql://localhost:3306/spring_mvc_db?useSSL=false";
		String uname = "springmvc";
		String pwd = "springmvc";

		try {
			System.out.println("Test Connection");
			Connection con = DriverManager.getConnection(jdbcUrl, uname, pwd);
			System.out.println("Connection Succesful");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
