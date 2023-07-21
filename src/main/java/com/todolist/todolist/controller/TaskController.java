package com.todolist.todolist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todolist.model.Task;
import com.todolist.todolist.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @Autowired
    private TaskService service;
    
    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findById(@PathVariable long id) {
        Task obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
