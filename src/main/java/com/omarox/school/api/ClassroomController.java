package com.omarox.school.api;

import com.omarox.school.model.Classroom;
import com.omarox.school.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/classroom")
@RestController
public class ClassroomController {
    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @PostMapping
    public void addClassroom(@RequestBody Classroom classroom) {
        classroomService.addClassroom(classroom);
    }

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping(path = "{id}")
    public Optional<Classroom> getClassroom(@PathVariable("id") UUID id) {
        return classroomService.getClassroomById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteClassroom(@PathVariable("id") UUID id) {
        classroomService.deleteClassroom(id);
    }

    @PutMapping(path = "{id}")
    public void updateClassroom(@PathVariable("id") UUID id, @RequestBody Classroom classroom) {
        classroomService.updateClassroom(id, classroom);
    }
}
