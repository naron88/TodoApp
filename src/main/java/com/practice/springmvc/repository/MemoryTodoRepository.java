package com.practice.springmvc.repository;

import com.practice.springmvc.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryTodoRepository implements TodoRepository {
    private final Map<UUID, Todo> storage = new ConcurrentHashMap<>();

    @Override
    public Todo save(Todo todo) {
        storage.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Optional<Todo> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(UUID id) {
        storage.remove(id);
    }
}
