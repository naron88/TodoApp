package com.practice.springmvc.dto;

import com.practice.springmvc.model.Todo;
import lombok.Getter;

import java.util.UUID;

@Getter
public class TodoResponse {
    private UUID id;
    private String title;
    private String details;
    private long createdAt;
    private long updatedAt;
    private boolean completed;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.details = todo.getDetails();
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
        this.completed = todo.isCompleted();
    }
}
