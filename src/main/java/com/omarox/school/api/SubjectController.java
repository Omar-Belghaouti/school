package com.omarox.school.api;

import com.omarox.school.model.Subject;
import com.omarox.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/subject")
@RestController
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public void addSubject(@RequestBody Subject subject) {
        subjectService.addSubject(subject);
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping(path = "{id}")
    public Optional<Subject> getSubject(@PathVariable("id") UUID id) {
        return subjectService.getSubjectById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteSubject(@PathVariable("id") UUID id) {
        subjectService.deleteSubject(id);
    }

    @PutMapping(path = "{id}")
    public void updateSubject(@PathVariable("id") UUID id, @RequestBody Subject subject) {
        subjectService.updateSubject(id, subject);
    }
}
