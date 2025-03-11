package tech.kianseong.tracker.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tech.kianseong.tracker.dto.TaskDto;
import tech.kianseong.tracker.model.Task;
import tech.kianseong.tracker.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private static final Task TASK_1 =
            new Task(1L, "Test Task 1", false, LocalDateTime.now(), LocalDateTime.now());
    private static final Task TASK_2 =
            new Task(2L, "Test Task 2", true, LocalDateTime.now(), LocalDateTime.now());

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTasks_ReturnsAllTasks_WhenNoFilter() {
        when(taskRepository.findAll()).thenReturn(List.of(TASK_1, TASK_2));

        List<TaskDto> tasks = taskService.getAllTasks(null);

        assertEquals(2, tasks.size());
        assertEquals("Test Task 1", tasks.get(0).description());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void testGetCompletedTasks_ReturnsCompletedTasks() {
        when(taskRepository.findByCompleted(true)).thenReturn(List.of(TASK_2));

        List<TaskDto> tasks = taskService.getAllTasks(true);

        assertEquals(1, tasks.size());
        assertEquals("Test Task 2", tasks.get(0).description());
        verify(taskRepository, times(1)).findByCompleted(true);
    }

    @Test
    void testGetUncompletedTasks_ReturnsUncompletedTasks() {
        when(taskRepository.findByCompleted(false)).thenReturn(List.of(TASK_1));

        List<TaskDto> tasks = taskService.getAllTasks(false);

        assertEquals(1, tasks.size());
        assertEquals("Test Task 1", tasks.get(0).description());
        verify(taskRepository, times(1)).findByCompleted(false);
    }

    @Test
    void testCreate_SaveTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(TASK_1);

        Task createdTask = taskService.create(TASK_1);

        assertNotNull(createdTask);
        assertEquals("Test Task 1", createdTask.getDescription());
        assertFalse(createdTask.isCompleted());
        verify(taskRepository, times(1)).save(any(Task.class));
    }
}
