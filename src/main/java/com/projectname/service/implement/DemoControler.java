package com.projectname.service.implement;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projectname.dao.repository.StudentRepository;
import com.projectname.dao.model.*;

@RestController
public class DemoControler {

	@Autowired(required = true)
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> getName(@RequestParam String name) {
		return studentRepository.findByName(name);
	}

	@PostMapping("/students")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Student saveStudent(@RequestBody Student student) {
		student.setCreationDate(LocalDateTime.now());
		return studentRepository.save(student);
	}

	@PutMapping("/students/{student_id}")
	public Student updateStudent(@PathVariable int student_id, @RequestBody Student student) {

		Student findStudent = new Student();

		findStudent = studentRepository.findById(student_id);

		student.setId(student_id);
		student.setCreationDate(findStudent.getCreationDate());

		return studentRepository.save(student);
	}

	@DeleteMapping("/students/{student_id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable Integer student_id) {

		studentRepository.deleteById(student_id);
	}
}
