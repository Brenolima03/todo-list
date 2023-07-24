package com.todolist.todolist.model;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.todolist.todolist.model.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_descriptions")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String description;
    private Integer status;
    private Integer priority;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT")
    private Instant moment;

    public Task() {
    }

    public Task(Long id, String description, TaskStatus status, Integer priority) {
        this.id = id;
        this.description = description;
        setStatus(status);
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return TaskStatus.valueOf(status);
    }

    public void setStatus(TaskStatus status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Descriptions [id=" + id + ", description=" + description + "]";
    }
}
