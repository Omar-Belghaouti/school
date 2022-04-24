package com.omarox.school.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Classroom {
    private final UUID id;
    private final List<UUID> teachers;
    private final List<UUID> students;

    public Classroom(
            @JsonProperty("id") UUID id,
            @JsonProperty("teachers") List<UUID> teachers,
            @JsonProperty("students") List<UUID> students) {
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
