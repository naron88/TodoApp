package com.practice.springmvc.dto;

import lombok.Getter;

@Getter
public class TodoRequest {
    private String title;
    private String details;

    public TodoRequest(String title, String details) {
        this.title = title;
        this.details = details;
    }
}
