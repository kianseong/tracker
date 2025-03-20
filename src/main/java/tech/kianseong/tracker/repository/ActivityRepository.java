package tech.kianseong.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kianseong.tracker.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Activity findActivityByName(String activityName);
}
