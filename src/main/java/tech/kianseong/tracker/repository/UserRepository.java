package tech.kianseong.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kianseong.tracker.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
