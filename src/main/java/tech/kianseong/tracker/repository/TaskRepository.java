package tech.kianseong.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.kianseong.tracker.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
