package com.khadri.spring.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khadri.spring.mvc.entity.Student;
import com.khadri.spring.mvc.jdbc.connection.JdbcConnection;

@Repository
public class StudentDao {

	@Autowired
	private JdbcConnection jdbcConnection;

	// insert student record
	public void insertStudent(Student student) {
		System.out.println("Entered into StudentDao : insertStudent(-)");

		Connection con = jdbcConnection.createConnection();

		String sql = "insert into student_register values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, student.getId());
			ps.setString(3, student.getAddress());
			ps.setInt(3, Integer.parseInt(student.getAge()));
			ps.setString(4, student.getBranch());
			ps.setString(5, student.getName());
			ps.setInt(6, Integer.parseInt(student.getParentPhone()));
			ps.setInt(7, Integer.parseInt(student.getPhone()));

			int result = ps.executeUpdate();
			System.out.println(result + " Rows Inserted Successfully");

		} catch (SQLException e) {
			System.out.println("Exception Occured " + e);
		}

	}

	// read all student records
	public List<Student> readAllStudents() {
		System.out.println("Entered into StudentDao : readAllStudents(-)");
		Connection con = jdbcConnection.createConnection();

		String sql = "select * from student_register";
		List<Student> allStudents = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {

				Student std = new Student();

				int stdId = resultSet.getInt(1);
				String address = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String branch = resultSet.getString(4);
				String name = resultSet.getString(5);
				int parentPhone = resultSet.getInt(6);
				int phone = resultSet.getInt(7);

				std.setId(stdId);
				std.setAddress(address);
				std.setAge(String.valueOf(age));
				std.setBranch(branch);
				std.setName(name);
				std.setParentPhone(String.valueOf(parentPhone));
				std.setPhone(String.valueOf(phone));

				allStudents.add(std);

			}

		} catch (SQLException e) {
			System.out.println("Exception Occured " + e.getMessage());
		} 	

		return allStudents;
	}

	// read student record by id
	public Student readStudent(Integer Id) {
		System.out.println("Entered into StudentDao : readStudent(-)");
		Connection con = jdbcConnection.createConnection();

		String sql = "select * from student_register where STUD_ID=" + Id;
		Student std = new Student();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {

				int stdId = resultSet.getInt(1);
				String address = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String branch = resultSet.getString(4);
				String name = resultSet.getString(5);
				int parentPhone = resultSet.getInt(6);
				int phone = resultSet.getInt(7);

				std.setId(stdId);
				std.setAddress(address);
				std.setAge(String.valueOf(age));
				std.setBranch(branch);
				std.setName(name);
				std.setParentPhone(String.valueOf(parentPhone));
				std.setPhone(String.valueOf(phone));

			}

		} catch (SQLException e) {
			System.out.println("Exception Occured " + e.getMessage());
		}

		return std;
	}

	// delete student record by id
	public void deleteStudent(Integer Id) {
		System.out.println("Entered into StudentDao : deleteStudent(-)");
		Connection con = jdbcConnection.createConnection();

		String sql = "delete from student_register where STUD_ID=" + Id;
		try {
			Statement stmt = con.createStatement();
			int executeUpdate = stmt.executeUpdate(sql);

			System.out.println(executeUpdate + " Record deleted ");

		} catch (SQLException e) {
			System.out.println("Exception Occured " + e.getMessage());
		}

	}

	// modify student record
	public void modifyStudent(Student student) {
		System.out.println("Entered into StudentDao : modifyStudent(-)");

		Connection con = jdbcConnection.createConnection();

		String sql = "update student_register set STUD_ADDRESS=?,STUD_AGE=?,STUD_BRANCH=?,STUD_NAME=?,STUD_PARENT_PHONE=?,STUD_PHONE=? where STUD_ID=?;";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, student.getAddress());
			ps.setInt(2, Integer.parseInt(student.getAge()));
			ps.setString(3, student.getBranch());
			ps.setString(4, student.getName());
			ps.setInt(5, Integer.parseInt(student.getParentPhone()));
			ps.setInt(6, Integer.parseInt(student.getPhone()));

			ps.setInt(7, student.getId());
			int result = ps.executeUpdate();
			System.out.println(result + " Rows Updated Successfully");

		} catch (SQLException e) {
			System.out.println("Exception Occured " + e.getMessage());
		}

	}

}
