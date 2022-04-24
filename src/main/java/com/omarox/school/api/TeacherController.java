package com.omarox.school.api;

import com.omarox.school.model.Teacher;
import com.omarox.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/teacher")
@RestController
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping(path = "{id}")
    public Optional<Teacher> getTeacher(@PathVariable("id")UUID id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTeacher(@PathVariable("id") UUID id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping(path = "{id}")
    public void updateTeacher(@PathVariable("id") UUID id, @RequestBody Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
    }
}
