package com.edutech.classroom.service;

import com.edutech.classroom.dto.StudentMarkDTO;
import com.edutech.classroom.entity.StudentMark;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.StudentMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentMarkService {
    private final StudentMarkRepository repo;

    public List<StudentMarkDTO> findAll(){
        return repo.findAll().stream().map(StudentMarkDTO::fromEntity).toList();
    }

    public StudentMarkDTO findById(Integer id){
        return StudentMarkDTO.fromEntity(repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Nota del estudiante no encontrada")));
    }

    public StudentMarkDTO create(StudentMarkDTO dto){
        return StudentMarkDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public StudentMarkDTO update(Integer id, StudentMarkDTO dto){
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nota del estudiante no encontrada"));
        StudentMark entity = dto.toEntity();
        entity.setId(id);
        return StudentMarkDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id){
        repo.delete(repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Nota del estudiante no encontrada")));
    }
}
