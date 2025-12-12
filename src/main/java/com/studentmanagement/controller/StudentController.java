package com.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.entity.Student;
import com.studentmanagement.service.StudentService;


@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String index() {
		return "index";
	}	
	@GetMapping("/students")
	public String listStudents(Model model) {
		List<Student> students =	service.getAllStudent();

		model.addAttribute("students", students);
		return "Students";
	}


	@GetMapping("/studentform")
	public String form(Model model) {
		model.addAttribute("student", new Student());
		return "AddStudentForm";
	}

	@PostMapping("/addstudent")
	public String save(@ModelAttribute Student stu) {
		service.addStudent(stu);
		return "redirect:/students";
	}

	@GetMapping("/edit/{id}")
	public String editforn(@PathVariable int id, Model model) {
		Student student =	service.getStudentById(id);
		model.addAttribute("student",student);
		return "EditStudentForm";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, @ModelAttribute Student student) {
		student.getId();
		service.updateStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		service.deleteStudent(id);
		return "redirect:/students";
	}

}
