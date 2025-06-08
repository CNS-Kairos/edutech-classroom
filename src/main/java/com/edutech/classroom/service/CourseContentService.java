package com.edutech.classroom.service;

import com.edutech.classroom.dto.CourseContentDTO;
import com.edutech.classroom.entity.CourseContent;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseContentService {
    private final CourseContentRepository repo;

    public List<CourseContentDTO> findAll() {
        return repo.findAll().stream().map(CourseContentDTO :: fromEntity).toList();
    }

    public CourseContentDTO findById(Integer id) {
        return CourseContentDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }

    public CourseContentDTO create(CourseContentDTO dto) {
        return CourseContentDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public CourseContentDTO update(Integer id, CourseContentDTO dto) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        CourseContent entity = dto.toEntity();
        entity.setId(id);
        return CourseContentDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        repo.delete(repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }
}
