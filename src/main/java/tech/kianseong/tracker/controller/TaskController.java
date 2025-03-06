package tech.kianseong.tracker.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.kianseong.tracker.model.Task;
import tech.kianseong.tracker.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
@Validated
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/")
    public Task createTask(@RequestBody @Valid Task task) {
        return taskService.create(task);
    }
}
