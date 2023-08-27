package com.khadri.spring.mvc.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.dao.StudentDao;
import com.khadri.spring.mvc.dao.StudentSpringDao;
import com.khadri.spring.mvc.dto.StudentDTO;
import com.khadri.spring.mvc.entity.Student;
import com.khadri.spring.mvc.jdbc.sequence.CustomSequence;

@Service
public class StudentService {

//	@Autowired
//	private StudentDao studentDao;
	
	@Autowired
	private StudentSpringDao studentSpringDao;

	@Autowired
	private CustomSequence customSequence;
 

	public void addStudent(StudentDTO studentDTO) {

		Function<StudentDTO, Student> convertDtoToEntity = (dto) -> {
			Student student = new Student();
			Integer sequence = customSequence.getSequence();
			student.setId(sequence);
			student.setName(dto.getName());
			student.setAge(dto.getAge());
			student.setBranch(dto.getBranch());
			student.setParentPhone(dto.getParentPhone());
			student.setPhone(dto.getPhone());
			student.setAddress(dto.getAddress());
			return student;
		};

		Student student = Optional.ofNullable(studentDTO).stream().map(convertDtoToEntity).findFirst().get();

//		studentDao.insertStudent(student); 
		
		
		studentSpringDao.insertStudent(student);
	}

	public List<StudentDTO> getAllStudents() {

//		List<Student> listOfStudents = studentDao.readAllStudents();
		List<Student> listOfStudents = studentSpringDao.readAllStudents();

		Function<Student, StudentDTO> convertEntityToDto = (student) -> {
			StudentDTO dto = new StudentDTO();
			dto.setId(student.getId());
			dto.setAddress(student.getAddress());
			dto.setAge(student.getAge());
			dto.setBranch(student.getBranch());
			dto.setName(student.getName());
			dto.setParentPhone(student.getParentPhone());
			dto.setPhone(student.getPhone());
			return dto;
		};

		List<StudentDTO> listOfStudentsDto = listOfStudents.stream().map(convertEntityToDto)
				.collect(Collectors.toList());

		return listOfStudentsDto;
	}

	public StudentDTO getStudent(Integer id) {

//		Student foundStudent = studentDao.readStudent(id);
		Student foundStudent = studentSpringDao.readStudent(id);

		Function<Student, StudentDTO> convertEntityToDto = (student) -> {
			StudentDTO dto = new StudentDTO();
			dto.setId(student.getId());
			dto.setAddress(student.getAddress());
			dto.setAge(student.getAge());
			dto.setBranch(student.getBranch());
			dto.setName(student.getName());
			dto.setParentPhone(student.getParentPhone());
			dto.setPhone(student.getPhone());
			return dto;
		};

		StudentDTO studentDTO = Optional.ofNullable(foundStudent).stream().map(convertEntityToDto).findFirst().get();

		return studentDTO;
	}

	public void deleteStudent(Integer id) {

		//studentDao.deleteStudent(id);
		studentSpringDao.deleteStudent(id);

	}

	public void modifyStudent(StudentDTO studentDTO) {

		Function<StudentDTO, Student> convertDtoToEntity = (dto) -> {
			Student student = new Student();
			student.setId(studentDTO.getId());
			student.setName(dto.getName());
			student.setAge(dto.getAge());
			student.setBranch(dto.getBranch());
			student.setParentPhone(dto.getParentPhone());
			student.setPhone(dto.getPhone());
			student.setAddress(dto.getAddress());
			return student;
		};

		Student student = Optional.ofNullable(studentDTO).stream().map(convertDtoToEntity).findFirst().get();

//		studentDao.modifyStudent(student);
		studentSpringDao.modifyStudent(student);
	}

}
