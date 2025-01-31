package com.practice.springmvc.service;

import com.practice.springmvc.dto.TodoRequest;
import com.practice.springmvc.dto.TodoResponse;
import com.practice.springmvc.exception.TodoNotFoundException;
import com.practice.springmvc.model.Todo;
import com.practice.springmvc.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponse createTodo(TodoRequest request) {
        Todo todo = new Todo(request.getTitle(), request.getDetails());
        return new TodoResponse(todoRepository.save(todo));
    }

    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(TodoResponse::new)
                .collect(Collectors.toList());
    }

    public TodoResponse getTodoById(UUID id) {
        return new TodoResponse(todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("TODO를 찾을 수 없습니다.")));
    }

    public TodoResponse updateTodo(UUID id, TodoRequest request, Boolean completed) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("TODO를 찾을 수 없습니다."));

        todo.update(request.getTitle(), request.getDetails(), completed);
        return new TodoResponse(todo);
    }

    public void deleteTodo(UUID id) {
        if (!todoRepository.findById(id).isPresent()) {
            throw new TodoNotFoundException("TODO를 찾을 수 없습니다.");
        }
        todoRepository.delete(id);
    }
}

