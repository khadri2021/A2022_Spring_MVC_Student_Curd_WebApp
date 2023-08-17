package com.khadri.spring.mvc.controller;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.mvc.dto.StudentDTO;
import com.khadri.spring.mvc.form.StudentForm;
import com.khadri.spring.mvc.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/adminpage")
	public String studentAdminPage() {
		return "student_admin";
	}

	@GetMapping("/addpage")
	public String addStudentPage() {
		return "add_student";
	}

	@PostMapping("/register")
	@ResponseBody
	public String addStudentForm(StudentForm studentForm) {

		Function<StudentForm, StudentDTO> convertFormToDto = (form) -> {
			StudentDTO dto = new StudentDTO();
			dto.setName(form.getsName());
			dto.setAge(form.getsAge());
			dto.setAddress(form.getsAddress());
			dto.setBranch(form.getsBranch());
			dto.setPhone(form.getsPhone());
			dto.setParentPhone(form.getsParentPhone());

			return dto;
		};

		StudentDTO studentDTO = Optional.ofNullable(studentForm).stream().map(convertFormToDto).findFirst().get();

		studentService.addStudent(studentDTO);
		
		return "inserted record!!!";
	}

}
