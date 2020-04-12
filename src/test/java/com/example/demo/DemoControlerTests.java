package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import com.projectname.dao.model.Student;
import com.projectname.dao.repository.StudentRepository;
import com.projectname.service.implement.DemoControler;

import org.junit.platform.runner.JUnitPlatform;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class DemoControlerTests {

	@InjectMocks
	DemoControler demoControler;
	
	@Mock
	StudentRepository studentRepository;
	
	@Test
	public void testGetNameOk() 
	{
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Ale");
		student1.setLastName("Diaz");
		student1.setDni(12345);
		student1.setDateOfBirth(LocalDate.of(1990, 01, 13)); 
		student1.setCreationDate(LocalDateTime.now());
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Ale");
		student2.setLastName("Sanz");
		student2.setDni(54321);
		student2.setDateOfBirth(LocalDate.of(1995, 01, 13)); 
		student2.setCreationDate(LocalDateTime.now());
		
		List<Student> studentList = Arrays.asList(student1,student2);
		when(studentRepository.findByName("Ale")).thenReturn(studentList);
		
		assertThat(demoControler.getName("Ale")).isEqualTo(Arrays.asList(student1,student2));
		
	}
	
	@Test
	public void testSaveStudentOk()
	{		
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Ale");
		student1.setLastName("Diaz");
		student1.setDni(12345);
		student1.setDateOfBirth(LocalDate.of(1990, 01, 13)); 
		student1.setCreationDate(LocalDateTime.now());
		
        when(studentRepository.save(any(Student.class))).thenReturn(student1);  
        
        assertThat(demoControler.saveStudent(student1)).isNotNull();
        assertThat(demoControler.saveStudent(student1).getCreationDate()).isEqualTo(student1.getCreationDate());
	}

}
