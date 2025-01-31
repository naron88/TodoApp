package com.practice.springmvc.controller;

import com.practice.springmvc.dto.TodoRequest;
import com.practice.springmvc.dto.TodoResponse;
import com.practice.springmvc.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping({"/api/todo"})
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@RequestBody @Valid TodoRequest request) {
        return ResponseEntity.status(201).body(this.todoService.createTodo(request));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        return ResponseEntity.ok(this.todoService.getAllTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable UUID id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(
            @PathVariable UUID id,
            @Valid @RequestBody TodoRequest request,
            @RequestParam(required = false) Boolean completed) {
        return ResponseEntity.ok(todoService.updateTodo(id, request, completed));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable UUID id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("TODO item successfully deleted");
    }
}
