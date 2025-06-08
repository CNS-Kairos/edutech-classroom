package com.edutech.classroom.service;

import com.edutech.classroom.dto.QuizResponseDTO;
import com.edutech.classroom.entity.QuizResponse;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.QuizResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class QuizResponseService {
    private final QuizResponseRepository repo;

    public List<QuizResponseDTO> findAll(){
        return repo.findAll().stream().map(QuizResponseDTO::fromEntity).toList();
    }

    public QuizResponseDTO findById(Integer id){
        return QuizResponseDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la respuesta al Quiz")));
    }

    public QuizResponseDTO create(QuizResponseDTO dto){
        return QuizResponseDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public QuizResponseDTO update(Integer id,QuizResponseDTO dto){
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro la respuesta del Quiz"));
        QuizResponse entity = dto.toEntity();
        entity.setId(id);
        return QuizResponseDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id){
        repo.delete(repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontro la respuesta del Quiz")));
    }
}
