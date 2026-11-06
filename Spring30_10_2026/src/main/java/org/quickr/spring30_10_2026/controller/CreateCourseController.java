
package org.quickr.spring30_10_2026.controller;

import org.quickr.spring30_10_2026.entity.Course;
import org.quickr.spring30_10_2026.service.CourseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/courses")
public class CreateCourseController {

    private final CourseService courseService;

    public CreateCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.createCourse(course);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCourse);
    }
}
