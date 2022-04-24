package com.omarox.school.model;

import java.util.List;
import java.util.UUID;

public class Classroom {
    private final UUID id;
    private final List<UUID> teachers;
    private final List<UUID> students;

    public Classroom(UUID id, List<UUID> teachers, List<UUID> students) {
        this.id = id;
        this.teachers = teachers;
        this.students = students;
    }

    public UUID getId() {
        return id;
    }

    public List<UUID> getTeachers() {
        return teachers;
    }

    public List<UUID> getStudents() {
        return students;
    }
}
