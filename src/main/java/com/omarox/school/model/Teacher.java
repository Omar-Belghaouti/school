package com.omarox.school.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Teacher {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final List<UUID> classrooms;
    private final UUID subject;

    public Teacher(
            @JsonProperty("id") UUID id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("classrooms") List<UUID> classrooms,
            @JsonProperty("subject") UUID subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classrooms = classrooms;
        this.subject = subject;
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

    public List<UUID> getClassrooms() {
        return classrooms;
    }

    public UUID getSubject() {
        return subject;
    }
}
