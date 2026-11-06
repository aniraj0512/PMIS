package org.quickr.spring30_10_2026.controller;

import org.quickr.spring30_10_2026.entity.Course;
import org.quickr.spring30_10_2026.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class GetAllCoursesController {

    private final CourseService courseService;

    public GetAllCoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
}