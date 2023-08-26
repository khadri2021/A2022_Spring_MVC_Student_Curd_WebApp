package com.khadri.spring.mvc.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.khadri.spring.mvc.dto.StudentDTO;
import com.khadri.spring.mvc.form.StudentForm;
import com.khadri.spring.mvc.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private ModelAndView modelAndView;

	@GetMapping("/adminpage")
	public String studentAdminPage() {
		return "student_admin";
	}

	@GetMapping("/addpage")
	public String addStudentPage() {
		return "add_student";
	}

	@GetMapping("/viewpage")
	public String viewStudentPage() {
		return "view_student";
	}

	@PostMapping("/add/register")
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

	@GetMapping("/view/all/registers")
	public ModelAndView viewStudentForms() {

		List<StudentDTO> listOfStudentsDto = studentService.getAllStudents();

		Function<StudentDTO, StudentForm> convertfromDtoToForm = (dto) -> {
			StudentForm form = new StudentForm();
			form.setsId(dto.getId());
			form.setsAddress(dto.getAddress());
			form.setsAge(dto.getAge());
			form.setsName(dto.getName());
			form.setsBranch(dto.getBranch());
			form.setsParentPhone(dto.getParentPhone());
			form.setsPhone(dto.getPhone());
			return form;
		};

		List<StudentForm> allStudents = listOfStudentsDto.stream().map(convertfromDtoToForm)
				.collect(Collectors.toList());

		modelAndView.addObject("edit_result", allStudents);
		modelAndView.setViewName("modify_student");

		return modelAndView;
	}

	@GetMapping("/delete/all/registers")
	public ModelAndView deleteStudentForms() {

		List<StudentDTO> listOfStudentsDto = studentService.getAllStudents();

		Function<StudentDTO, StudentForm> convertfromDtoToForm = (dto) -> {
			StudentForm form = new StudentForm();
			form.setsId(dto.getId());
			form.setsAddress(dto.getAddress());
			form.setsAge(dto.getAge());
			form.setsName(dto.getName());
			form.setsBranch(dto.getBranch());
			form.setsParentPhone(dto.getParentPhone());
			form.setsPhone(dto.getPhone());
			return form;
		};

		List<StudentForm> allStudents = listOfStudentsDto.stream().map(convertfromDtoToForm)
				.collect(Collectors.toList());

		modelAndView.addObject("delete_result", allStudents);
		modelAndView.setViewName("delete_student");

		return modelAndView;
	}

	@GetMapping("/view/register")
	public ModelAndView viewStudentForm(@RequestParam("stdid") Integer id) {

		StudentDTO foundStudentsDto = studentService.getStudent(id);

		Function<StudentDTO, StudentForm> convertfromDtoToForm = (dto) -> {
			StudentForm form = new StudentForm();
			form.setsId(dto.getId());
			form.setsAddress(dto.getAddress());
			form.setsAge(dto.getAge());
			form.setsName(dto.getName());
			form.setsBranch(dto.getBranch());
			form.setsParentPhone(dto.getParentPhone());
			form.setsPhone(dto.getPhone());
			return form;
		};

		StudentForm studentForm = Optional.ofNullable(foundStudentsDto).stream().map(convertfromDtoToForm).findFirst()
				.get();

		modelAndView.addObject("search_result", studentForm);
		modelAndView.setViewName("view_student");

		return modelAndView;
	}

	@PostMapping("/modify/register")
	@ResponseBody
	public String modifyStudentForm(StudentForm studentForm) {

		Function<StudentForm, StudentDTO> convertFormToDto = (form) -> {
			StudentDTO dto = new StudentDTO();
			dto.setId(form.getsId());
			dto.setName(form.getsName());
			dto.setAge(form.getsAge());
			dto.setAddress(form.getsAddress());
			dto.setBranch(form.getsBranch());
			dto.setPhone(form.getsPhone());
			dto.setParentPhone(form.getsParentPhone());

			return dto;
		};

		StudentDTO studentDTO = Optional.ofNullable(studentForm).stream().map(convertFormToDto).findFirst().get();

		studentService.modifyStudent(studentDTO);

		return "updated record!!!";
	}

	@PostMapping("/delete/register")
	@ResponseBody
	public String deleteStudentForm(@RequestParam("sId") Integer id) {
		studentService.deleteStudent(id);

		return "deleted record!!!";
	}

}
