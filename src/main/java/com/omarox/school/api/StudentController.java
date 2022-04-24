package com.omarox.school.api;

import com.omarox.school.model.Student;
import com.omarox.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Optional<Student> getStudent(@PathVariable("id") UUID id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") UUID id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") UUID id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }
}
