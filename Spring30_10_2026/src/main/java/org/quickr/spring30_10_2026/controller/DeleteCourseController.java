
package org.quickr.spring30_10_2026.controller;

import org.quickr.spring30_10_2026.service.CourseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/courses")
public class DeleteCourseController {

    private final CourseService courseService;

    public DeleteCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {

        boolean deleted = courseService.deleteCourse(courseId);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
