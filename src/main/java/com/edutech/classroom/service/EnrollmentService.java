package com.edutech.classroom.service;

import com.edutech.classroom.dto.EnrollmentDTO;
import com.edutech.classroom.entity.Enrollment;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository repo;

    public List<EnrollmentDTO> findAll(){
        return repo.findAll().stream().map(EnrollmentDTO::fromEntity).toList();
    }

    public EnrollmentDTO findById(Integer id){
        return EnrollmentDTO.fromEntity(repo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }

    public EnrollmentDTO update(EnrollmentDTO dto, Integer id){
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        Enrollment entity = dto.toEntity();
        entity.setId(id);
        return EnrollmentDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id){
        repo.delete(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id)));
    }
}
