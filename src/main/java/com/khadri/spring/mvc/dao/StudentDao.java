package com.khadri.spring.mvc.dao;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.entity.Student;

@Component
public class StudentDao {

	public void insertStudent(Student student) {
		// logic to store data into database
		System.out.println("Entered into StudentDao");
	}
}
