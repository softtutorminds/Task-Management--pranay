package com.pranay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pranay.model.Task;
import com.pranay.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Display all tasks
    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task-list";
    }

    // Show form for adding a new task
    @GetMapping("/add")
    public String showAddTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "add-task";
    }

    // Add new task
    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    // Delete a task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    // Mark task as completed
    @PostMapping("/complete/{id}")
    public String completeTask(@PathVariable("id") int id) {
        taskService.completeTask(id);
        return "redirect:/tasks";
    }
}
