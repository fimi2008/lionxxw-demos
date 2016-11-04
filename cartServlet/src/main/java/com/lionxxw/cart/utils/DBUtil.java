package com.lionxxw.cart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	private static final String PWD = "root";
	private static Connection conn = null;
	
	static {
		try {
			// 1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获得数据库的连接
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}
	
	public static void main(String[] args) throws Exception {
		// 1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获得数据库的连接
		Connection conn = DriverManager.getConnection(URL, USER, PWD);
		// 3.通过数据库的连接操作数据库,实现CRUD
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select userName, age from goddess");
		while (rs.next()){
			String name = rs.getString("userName");
			int age = rs.getInt("age");
			System.out.println(name + age);
		}
	}
}
