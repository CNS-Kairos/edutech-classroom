package com.edutech.classroom.service;

import com.edutech.classroom.dto.CourseDTO;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repo;

    public List<CourseDTO> findAll() {
        return repo.findAll().stream().map(CourseDTO :: fromEntity).toList();
    }

    public CourseDTO findById(Integer id) {
        return CourseDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }

    public CourseDTO create(CourseDTO dto) {
        return  CourseDTO.fromEntity(repo.save(CourseDTO.toEntity(dto)));
    }

    public CourseDTO update(Integer id, CourseDTO dto) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        Course entity = dto.toEntity();
        entity.setId(id);
        return  CourseDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        repo.delete(repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }
}
