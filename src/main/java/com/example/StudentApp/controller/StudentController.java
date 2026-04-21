package com.example.StudentApp.controller;



import com.example.StudentApp.entity.Student;
import com.example.StudentApp.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Student add(@RequestBody Student s) {
        return repo.save(s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        Student existing = repo.findById(id).orElseThrow();
        existing.setName(s.getName());
        existing.setCourse(s.getCourse());
        return repo.save(existing);
    }
}