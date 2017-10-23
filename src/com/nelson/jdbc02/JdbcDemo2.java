package com.nelson.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nelson.domain.Student;

import sun.security.timestamp.TSRequest;

public class JdbcDemo2 {
//	@Test
	public void insert() throws Exception {
		// 1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.得到连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hxzy", "root", "131416");
		// 准备sql语句
		String sql = "insert into student values(?,?,?,?)";
		// 4.把sql语句放到预编译对象里面
		PreparedStatement pstm = con.prepareStatement(sql);

		pstm.setInt(1, 24);
		pstm.setString(2, "张大");
		pstm.setInt(3, 12);
		pstm.setString(4, "男");

		int n = pstm.executeUpdate();
		if (n > 0) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
		pstm.close();
		con.close();
	}
//@Test
	public void delete() throws Exception {
		// 1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.得到连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hxzy", "root", "131416");
		// 准备sql语句
		String sql = "delete from student where sid = ?";
		// 4.把sql语句放到预编译对象里面
		PreparedStatement pstm = con.prepareStatement(sql);

		pstm.setInt(1, 24);
		
		int n = pstm.executeUpdate();
		if (n > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		pstm.close();
		con.close();
	}
//@Test
public void update() throws Exception{
	// 1.加载驱动
	Class.forName("com.mysql.jdbc.Driver");
	// 2.得到连接
	Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/hxzy", "root", "131416");
	// 准备sql语句
	String sql = "update student set sname= ? where sid =?";
	// 4.把sql语句放到预编译对象里面
	PreparedStatement pstm = con.prepareStatement(sql);

	pstm.setString(1, "旺财");
	pstm.setInt(2, 22);
	
	int n = pstm.executeUpdate();
	if (n > 0) {
		System.out.println("更新成功");
	} else {
		System.out.println("更新失败");
	}
	pstm.close();
	con.close();
}
@Test
public void select() throws Exception{
	// 1.加载驱动
	Class.forName("com.mysql.jdbc.Driver");
	// 2.得到连接
	Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/hxzy", "root", "131416");
	// 准备sql语句
	String sql = "select * from student where sid = ?";
	// 4.把sql语句放到预编译对象里面
	PreparedStatement pstm = con.prepareStatement(sql);
	pstm.setInt(1, 11);
	ResultSet rs= pstm.executeQuery();
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

	
	pstm.close();
	con.close();
	}
}