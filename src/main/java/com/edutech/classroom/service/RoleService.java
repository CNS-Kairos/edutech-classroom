package com.edutech.classroom.service;

import com.edutech.classroom.dto.RoleDTO;
import com.edutech.classroom.entity.Role;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RoleService {
    private final RoleRepository repo;

    public List<RoleDTO> findAll(){
        return repo.findAll().stream().map(RoleDTO::fromEntity).toList();
    }

    public RoleDTO findByID(Integer id){
        return RoleDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado")));
    }

    public RoleDTO create(RoleDTO dto){
        return RoleDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public RoleDTO update(Integer id, RoleDTO dto){
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));
        Role entity = dto.toEntity();
        entity.setId(id);
        return RoleDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id){
        repo.delete(repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Rol no encontrado")));
    }
}
