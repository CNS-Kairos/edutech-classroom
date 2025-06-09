package com.edutech.classroom.service;

import com.edutech.classroom.dto.CourseCommentDTO;
import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseCommentService {
    private final CourseCommentRepository repo;

    public List<CourseCommentDTO> findAll() {
        return repo.findAll().stream().map(CourseCommentDTO :: fromEntity).toList();
    }

    public CourseCommentDTO findById(Integer id) {
        return CourseCommentDTO.fromEntity(repo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }

    public CourseCommentDTO create(CourseCommentDTO dto) {
        return CourseCommentDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public CourseCommentDTO update(Integer id, CourseCommentDTO dto) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        CourseComment entity = dto.toEntity();
        entity.setId(id);
        return CourseCommentDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        repo.delete(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }

}
