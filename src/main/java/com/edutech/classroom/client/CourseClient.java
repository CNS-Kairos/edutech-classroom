package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-course", url = "http://localhost:8080/api/courses")
public interface CourseClient {
    @GetMapping("/{id}")
    Object getCourseById(@PathVariable("id") String id);

}
