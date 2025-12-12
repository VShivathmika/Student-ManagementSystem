package com.studentmanagement.api;


import java.util.List;
import java.util.stream.Collectors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.studentmanagement.dto.StudentDTO;
import com.studentmanagement.entity.Student;
import com.studentmanagement.service.StudentService;


import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/students")
public class StudentRestController {


private final StudentService service;


public StudentRestController(StudentService service) {
this.service = service;
}


@GetMapping
public List<Student> getAll() {
return service.getAllStudent();
}


@GetMapping("/{id}")
public ResponseEntity<Student> getById(@PathVariable int id) {
Student s = service.getStudentById(id);
return ResponseEntity.ok(s);
}


@PostMapping
public ResponseEntity<Student> create(@Valid @RequestBody StudentDTO dto) {
Student s = new Student();
s.setName(dto.getName());
s.setEmail(dto.getEmail());
s.setCourse(dto.getCourse());
service.addStudent(s);
return new ResponseEntity<>(s, HttpStatus.CREATED);
}


@PutMapping("/{id}")
public ResponseEntity<Student> update(@PathVariable int id, @Valid @RequestBody StudentDTO dto) {
Student existing = service.getStudentById(id);
existing.setName(dto.getName());
existing.setEmail(dto.getEmail());
existing.setCourse(dto.getCourse());
service.updateStudent(existing);
return ResponseEntity.ok(existing);
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable int id) {
service.deleteStudent(id);
return ResponseEntity.noContent().build();
}
}

