package com.practice.springmvc.repository;

import com.practice.springmvc.model.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository {
    Todo save(Todo todo);
    Optional<Todo> findById(UUID id);
    List<Todo> findAll();
    void delete(UUID id);
}
