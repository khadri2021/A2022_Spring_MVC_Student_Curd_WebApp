package com.khadri.spring.mvc.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.dao.StudentDao;
import com.khadri.spring.mvc.dto.StudentDTO;
import com.khadri.spring.mvc.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public void addStudent(StudentDTO studentDTO) {

		Function<StudentDTO, Student> convertDtoToEntity = (dto) -> {
			Student student = new Student();
			student.setName(dto.getName());
			student.setAge(dto.getAge());
			student.setBranch(dto.getBranch());
			student.setParentPhone(dto.getParentPhone());
			student.setPhone(dto.getPhone());
			student.setAddress(dto.getAddress());
			return student;
		};

		Student student = Optional.ofNullable(studentDTO).stream().map(convertDtoToEntity).findFirst().get();

		studentDao.insertStudent(student);
	}

}
