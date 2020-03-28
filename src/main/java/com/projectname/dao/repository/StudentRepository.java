package com.projectname.dao.repository;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectname.dao.model.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Id>{

	//boolean saveOrUpdate(Student student);
	List<Student> findByName(String name);
}
