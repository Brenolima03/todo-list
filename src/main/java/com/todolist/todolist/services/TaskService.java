package com.todolist.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.todolist.todolist.model.Task;
import com.todolist.todolist.repositories.TaskRepository;
import com.todolist.todolist.services.exceptions.DatabaseException;
import com.todolist.todolist.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task insert(Task obj) {
        return repository.save(obj);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(long id) {
        Optional<Task> obj = repository.findById(id);
        return obj.get();
    }

    public Task update(Long id, Task obj) {
        try {
            Task entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Task entity, Task obj) {
        entity.setPriority(obj.getPriority());
        entity.setDescription(obj.getDescription());
        entity.setStatus(obj.getStatus());
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
