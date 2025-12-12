package com.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.entity.Student;
import com.studentmanagement.reposistory.StudentReposistory;



@Service
public class StudentService {
	
	@Autowired
	private StudentReposistory repo;
	
	public void addStudent(Student stu) {
		repo.save(stu);

	}

	public void updateStudent(Student stu) {
		repo.save(stu);

	}

	public void deleteStudent(int id) {
		repo.deleteById(id);

	}
	public Student getStudentById(int id) {
		Student stu =	repo.findById(id).get();
		return stu;

	}
	public List<Student> getAllStudent() {
		return repo.findAll();

	}


	

}
