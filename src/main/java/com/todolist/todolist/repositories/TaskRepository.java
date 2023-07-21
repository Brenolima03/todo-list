package com.todolist.todolist.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.todolist.model.Task;

@Repository // Optional annotation because it's already inheriting from JpaRepository
public interface TaskRepository extends JpaRepository <Task, Long>{
    
}