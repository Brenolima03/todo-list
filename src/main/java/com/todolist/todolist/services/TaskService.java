package com.todolist.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolist.model.Task;
import com.todolist.todolist.repositories.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(long id) {
        Optional<Task> obj = repository.findById(id);
        return obj.get();
    }
}
