package com.edutech.classroom.service;

import com.edutech.classroom.dto.CourseQuizDTO;
import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseQuizService {
    private final CourseQuizRepository repo;

    public List<CourseQuizDTO> findAll() {
        return repo.findAll().stream().map(CourseQuizDTO::fromEntity).toList();
    }

    public CourseQuizDTO findById(Integer id) {
        return CourseQuizDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }

    public CourseQuizDTO create(CourseQuizDTO dto) {
        return CourseQuizDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public CourseQuizDTO update(Integer id, CourseQuizDTO dto) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        CourseQuiz entity = dto.toEntity();
        entity.setId(id);
        return CourseQuizDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        repo.delete(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }
}
