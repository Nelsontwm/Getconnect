package com.nelson.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nelson.domain.Student;
import com.sun.org.apache.regexp.internal.recompile;




public class JdbcDemo {
//	@Test
	public void select01 () throws Exception{
//		��������
		Class.forName("com.mysql.jdbc.Driver");
//		�õ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hxzy","root","131416");
//		��������sql����
		Statement stm = con.createStatement();
		ResultSet rs= stm.executeQuery("select * from student");
		
		while(rs.next()){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
		}
		rs.close();
		con.close();
		stm.close();
	}
//	@Test
	public void select02() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hxzy","root","131416");
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
//	@Test
	public void insert() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hxzy","root","131416");
		Statement stm = con.createStatement();
		
		int n = stm.executeUpdate("insert into student values(11,'����',23,'Ů')");
		
		if(n>0){
			System.out.println("����ɹ�");
		}else {
			System.out.println("����ʧ��");
		}
		stm.close();
		con.close();
	}
//	@Test
	public void delete() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hxzy","root","131416");
		Statement stm = con.createStatement();
		
		int n = stm.executeUpdate("delete from student where sid = '4'");
		
		if(n>0){
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
		stm.close();
		con.close();
	}
	@Test
	public void update() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hxzy","root","131416");
		Statement stm = con.createStatement();
		
		int n = stm.executeUpdate("update student set sname='����' where sid = 11");
		
		if(n>0){
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
		stm.close();
		con.close();
	}
}