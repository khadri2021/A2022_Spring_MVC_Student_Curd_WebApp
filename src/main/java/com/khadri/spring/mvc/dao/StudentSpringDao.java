package com.khadri.spring.mvc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.khadri.spring.mvc.entity.Student;

@Repository
public class StudentSpringDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// insert student record
	public void insertStudent(Student student) {
		System.out.println("Entered into StudentSpringDao : insertStudent(-)");

		String sql = "insert into student_register values(?,?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, student.getId(), student.getAddress(), student.getAge(),
				student.getBranch(), student.getName(), student.getParentPhone(), student.getPhone());
		System.out.println(result + " Rows Inserted Successfully");

	}

	// read all student records
	public List<Student> readAllStudents() {
		System.out.println("Entered into StudentSpringDao : readAllStudents(-)");

		String sql = "select * from student_register";
		RowMapper<Student> rowMapper = rowMapperForStudent();
		List<Student> listOfStudent = jdbcTemplate.query(sql, rowMapper);

		return listOfStudent;

	}

	// read student record by id
	public Student readStudent(Integer Id) {
		System.out.println("Entered into StudentSpringDao : readStudent(-)");

		String sql = "select * from student_register where STUD_ID=" + Id;
		RowMapper<Student> rowMapper = rowMapperForStudent();
		Student student = jdbcTemplate.queryForObject(sql, rowMapper);

		return student;
	}

	// delete student record by id
	public void deleteStudent(Integer Id) {
		System.out.println("Entered into StudentSpringDao : deleteStudent(-)");

		String sql = "delete from student_register where STUD_ID=" + Id;
		int result = jdbcTemplate.update(sql);
		System.out.println(result + " Record deleted ");
	}

	// modify student record
	public void modifyStudent(Student student) {
		System.out.println("Entered into StudentSpringDao : modifyStudent(-)");

		String sql = "update student_register set STUD_ADDRESS=?,STUD_AGE=?,STUD_BRANCH=?,STUD_NAME=?,STUD_PARENT_PHONE=?,STUD_PHONE=? where STUD_ID=?;";
		int result = jdbcTemplate.update(sql, student.getAddress(), student.getAge(), student.getBranch(),
				student.getName(), student.getParentPhone(), student.getPhone(), student.getId());
		System.out.println(result + " Rows Updated Successfully");

	}

	private RowMapper<Student> rowMapperForStudent() {
		
		Optional<RowMapper<Student>> optional = Optional.ofNullable((resultSet, rowNum) -> {
			Student student = new Student();

				student.setId(resultSet.getInt("STUD_ID"));
				student.setAddress(resultSet.getString("STUD_ADDRESS"));
				student.setAge(resultSet.getString("STUD_AGE"));
				student.setPhone(resultSet.getString("STUD_PHONE"));
				student.setParentPhone(resultSet.getString("STUD_PARENT_PHONE"));
				student.setName(resultSet.getString("STUD_NAME"));
				student.setBranch(resultSet.getString("STUD_BRANCH"));

			return student;
		});
		
		 
		return optional.isEmpty() ? null : optional.get();
	}

}
