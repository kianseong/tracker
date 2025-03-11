package tech.kianseong.tracker.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.kianseong.tracker.dto.TaskDto;
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
    public List<TaskDto> getAllTasks(@RequestParam(required = false) Boolean completed) {
        return taskService.getAllTasks(completed);
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> createTask(@RequestBody @Valid Task task) {
        taskService.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
