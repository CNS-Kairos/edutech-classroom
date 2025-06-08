package com.edutech.classroom.service;

import com.edutech.classroom.dto.CourseQuizQuestionDTO;
import com.edutech.classroom.entity.CourseQuizQuestion;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseQuizQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseQuizQuestionService {
    private final CourseQuizQuestionRepository repo;

    public List<CourseQuizQuestionDTO> findAll() {
        return repo.findAll().stream().map(CourseQuizQuestionDTO::fromEntity).toList();
    }

    public CourseQuizQuestionDTO findById(Integer id) {
        return CourseQuizQuestionDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }

    public CourseQuizQuestionDTO create(CourseQuizQuestionDTO dto) {
        return CourseQuizQuestionDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public CourseQuizQuestionDTO update(Integer id, CourseQuizQuestionDTO dto) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        CourseQuizQuestion entity = dto.toEntity();
        entity.setId(id);
        return CourseQuizQuestionDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        repo.delete(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }
}
