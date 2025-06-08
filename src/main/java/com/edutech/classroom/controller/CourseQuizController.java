package com.edutech.classroom.controller;

import com.edutech.classroom.dto.CourseQuizDTO;
import com.edutech.classroom.service.CourseQuizService;
import feign.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-quiz")
@RequiredArgsConstructor
public class CourseQuizController {
    private final CourseQuizService service;

    @GetMapping
    public ResponseEntity<List<CourseQuizDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseQuizDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourseQuizDTO> create(@RequestBody @Valid CourseQuizDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseQuizDTO> update(@PathVariable Integer id, @Valid @RequestBody CourseQuizDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseQuizDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
