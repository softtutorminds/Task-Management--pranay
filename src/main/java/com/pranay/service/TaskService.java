package com.pranay.service;

import org.springframework.stereotype.Service;

import com.pranay.model.Task;
import com.pranay.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Add a new task
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    // Delete a task
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    // Mark a task as completed
    public void completeTask(int id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));
        task.setCompleted(true);
        taskRepository.save(task);
    }
}
