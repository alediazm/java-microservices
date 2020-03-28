package com.projectname.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
