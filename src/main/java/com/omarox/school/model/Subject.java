package com.omarox.school.model;

import java.util.UUID;

public class Subject {
    private final UUID id;
    private final String name;

    public Subject(UUID id, String name) {
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
