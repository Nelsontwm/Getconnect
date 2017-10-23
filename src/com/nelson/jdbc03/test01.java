package com.nelson.jdbc03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nelson.domain.Student;

public class test01 {
	public static void main(String[] args) throws Exception {
		Connection con = Jdbcutil.getConection();
		System.out.println(con+"Á´½Ó³É¹¦");
		
		Statement stm = con.createStatement();
		ResultSet rs= stm.executeQuery("select * from student");
		
		List<Student> ss = new ArrayList<Student>();
		while (rs.next()) {
			Student s = new Student();
			
			s.setSid(rs.getInt("sid"));
			s.setSname(rs.getString("sname"));
			s.setSage(rs.getInt("sage"));
			s.setSsex(rs.getString("ssex"));
			
			ss.add(s);
			
		}
		for(Student s1 :ss){
			System.out.println(s1);
		}
		rs.close();
		stm.close();
		con.close();
	}
}	
