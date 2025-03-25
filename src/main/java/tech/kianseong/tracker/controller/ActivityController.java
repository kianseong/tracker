package tech.kianseong.tracker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.kianseong.tracker.dto.activities.AddTimeDto;
import tech.kianseong.tracker.dto.activities.ActivityDto;
import tech.kianseong.tracker.model.Activity;
import tech.kianseong.tracker.service.ActivityService;

import java.time.Duration;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/activities")
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody ActivityDto request) {
        return ResponseEntity.ok(activityService.createActivity(request.name()));
    }

    @PatchMapping("/{name}/add-time")
    public ResponseEntity<Activity> addTime(@PathVariable String name, @RequestBody AddTimeDto request) {
        return ResponseEntity.ok(activityService.addTime(name, Duration.ofSeconds(request.seconds())));
    }
}
