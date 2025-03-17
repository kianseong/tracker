package tech.kianseong.tracker.dto;

import tech.kianseong.tracker.model.Task;

public record TaskDto(long id, String description, boolean completed) {
    public static TaskDto of(Task task) {
        return new TaskDto(task.getId(), task.getDescription(), task.isCompleted());
    }
}
