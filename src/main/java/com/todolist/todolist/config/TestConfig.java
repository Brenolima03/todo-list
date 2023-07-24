package com.todolist.todolist.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.todolist.todolist.model.Task;
import com.todolist.todolist.model.enums.TaskStatus;
import com.todolist.todolist.repositories.TaskRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        Task task1 = new Task(1L, "Upload receipts", TaskStatus.NOT_ASSIGNED, 5);
        Task task2 = new Task(2L, "Clean the room", TaskStatus.INCOMPLETE, 1);

        taskRepository.saveAll(Arrays.asList(task1, task2));
    }
}
