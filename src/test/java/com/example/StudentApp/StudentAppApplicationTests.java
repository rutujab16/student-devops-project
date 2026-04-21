package com.example.StudentApp;

import com.example.StudentApp.entity.Student;
import com.example.StudentApp.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class StudentControllerTest {

	@Autowired
	private StudentRepository repo;

	@Test
	void testAddStudent() {
		Student s = new Student();
		s.setName("Test Student");
		s.setCourse("Java");

		Student saved = repo.save(s);

		assertNotNull(saved.getId());
	}

	@Test
	void testGetStudents() {
		List<Student> students = repo.findAll();
		assertNotNull(students);
	}

	@Test
	void testDeleteStudent() {
		Student s = new Student();
		s.setName("Delete Student");
		s.setCourse("Test");

		Student saved = repo.save(s);
		repo.deleteById(saved.getId());

		assertFalse(repo.findById(saved.getId()).isPresent());
	}
}