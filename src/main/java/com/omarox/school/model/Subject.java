package com.omarox.school.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Subject {
    private final UUID id;
    private final String name;

    public Subject(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
