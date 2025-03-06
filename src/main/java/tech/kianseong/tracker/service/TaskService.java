package tech.kianseong.tracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.kianseong.tracker.model.Task;
import tech.kianseong.tracker.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task create(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }
}
