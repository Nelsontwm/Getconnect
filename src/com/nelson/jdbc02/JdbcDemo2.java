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
		// 1.��������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.�õ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hxzy", "root", "131416");
		// ׼��sql���
		String sql = "insert into student values(?,?,?,?)";
		// 4.��sql���ŵ�Ԥ�����������
		PreparedStatement pstm = con.prepareStatement(sql);

		pstm.setInt(1, 24);
		pstm.setString(2, "�Ŵ�");
		pstm.setInt(3, 12);
		pstm.setString(4, "��");

		int n = pstm.executeUpdate();
		if (n > 0) {
			System.out.println("��ӳɹ�");
		} else {
			System.out.println("���ʧ��");
		}
		pstm.close();
		con.close();
	}
//@Test
	public void delete() throws Exception {
		// 1.��������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.�õ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hxzy", "root", "131416");
		// ׼��sql���
		String sql = "delete from student where sid = ?";
		// 4.��sql���ŵ�Ԥ�����������
		PreparedStatement pstm = con.prepareStatement(sql);

		pstm.setInt(1, 24);
		
		int n = pstm.executeUpdate();
		if (n > 0) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
		pstm.close();
		con.close();
	}
//@Test
public void update() throws Exception{
	// 1.��������
	Class.forName("com.mysql.jdbc.Driver");
	// 2.�õ�����
	Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/hxzy", "root", "131416");
	// ׼��sql���
	String sql = "update student set sname= ? where sid =?";
	// 4.��sql���ŵ�Ԥ�����������
	PreparedStatement pstm = con.prepareStatement(sql);

	pstm.setString(1, "����");
	pstm.setInt(2, 22);
	
	int n = pstm.executeUpdate();
	if (n > 0) {
		System.out.println("���³ɹ�");
	} else {
		System.out.println("����ʧ��");
	}
	pstm.close();
	con.close();
}
@Test
public void select() throws Exception{
	// 1.��������
	Class.forName("com.mysql.jdbc.Driver");
	// 2.�õ�����
	Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/hxzy", "root", "131416");
	// ׼��sql���
	String sql = "select * from student where sid = ?";
	// 4.��sql���ŵ�Ԥ�����������
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