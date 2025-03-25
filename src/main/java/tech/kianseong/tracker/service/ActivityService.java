package tech.kianseong.tracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.kianseong.tracker.model.Activity;
import tech.kianseong.tracker.repository.ActivityRepository;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity getActivityByName(String name) {
        return activityRepository.findActivityByName(name);
    }

    public Activity createActivity(String name) {
        Activity activity = new Activity(null, name, 0);
        return activityRepository.save(activity);
    }

    @Transactional
    public Activity addTime(String name, Duration duration) {
        Activity activity = getActivityByName(name);

        activity.setTotalTime(activity.getTotalTime().plus(duration));
        return activityRepository.save(activity);
    }
}
