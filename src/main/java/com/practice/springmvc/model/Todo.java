package com.practice.springmvc.model;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class Todo {
    private final UUID id = UUID.randomUUID();
    private String title;
    private String details;
    private final long createdAt;
    private long updatedAt;
    private boolean completed;

    public Todo(String title, String details) {
        this.title = title;
        this.details = details;
        this.createdAt = Instant.now().getEpochSecond();
        this.updatedAt = this.createdAt;
        this.completed = false;
    }

    public void update(String title, String details, Boolean completed) {
        if (title != null) {
            this.title = title;
        }

        if (details != null) {
            this.details = details;
        }

        if (completed != null) {
            this.completed = completed;
        }

        this.updatedAt = Instant.now().getEpochSecond();
    }
}
