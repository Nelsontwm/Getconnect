package com.nelson.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbcutil {
	
	public static Connection getConection() throws Exception{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/hxzy";
		String user = "root";
		String password = "131416";
	        Connection conn=null;
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			return conn;
	
	}
}
	

