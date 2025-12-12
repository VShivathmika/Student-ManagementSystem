package com.studentmanagement.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.entity.Student;

public interface StudentReposistory  extends JpaRepository<Student, Integer>{

}
