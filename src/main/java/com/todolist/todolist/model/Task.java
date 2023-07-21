package com.todolist.todolist.model;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.todolist.todolist.model.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tasks")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long priority;
    private String task;
    private Integer status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Instant moment; 

    public Task() {
    }

    public Task(Long priority, String task, TaskStatus status) {
        this.priority = priority;
        this.task = task;
        setStatus(status);
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getTasks() {
        return task;
    }

    public void setTasks(String task) {
        this.task = task;
    }

    public TaskStatus getStatus() {
        return TaskStatus.valueOf(status);
    }
    public void setStatus(TaskStatus status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((priority == null) ? 0 : priority.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (priority == null) {
            if (other.priority != null)
                return false;
        } else if (!priority.equals(other.priority))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tasks [priority=" + priority + ", task=" + task + "]";
    }
}
