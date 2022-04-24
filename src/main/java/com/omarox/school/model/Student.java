package com.omarox.school.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Student {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final List<UUID> teachers;
    private final List<UUID> subjects;

    public Student(
            @JsonProperty("id") UUID id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("age") int age,
            @JsonProperty("teachers") List<UUID> teachers,
            @JsonProperty("subjects") List<UUID> subjects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.teachers = teachers;
        this.subjects = subjects;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public List<UUID> getTeachers() {
        return teachers;
    }

    public List<UUID> getSubjects() {
        return subjects;
    }
}
