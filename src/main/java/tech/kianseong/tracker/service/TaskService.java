package tech.kianseong.tracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.kianseong.tracker.dto.TaskDto;
import tech.kianseong.tracker.model.Task;
import tech.kianseong.tracker.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream().map(TaskDto::of).collect(Collectors.toList());
    }

    public Task create(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }
}
