package com.edutech.classroom.service;

import com.edutech.classroom.dto.UserDTO;
import com.edutech.classroom.entity.User;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public List<UserDTO> findAll() {
        return repo.findAll().stream().map(UserDTO::fromEntity).toList();
    }

    public UserDTO findById(Integer id) {
        return UserDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado")));
    }

    public UserDTO create(UserDTO dto) {
        return UserDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public UserDTO update(Integer id, UserDTO dto) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        User entity = dto.toEntity();
        entity.setId(id);
        return UserDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        repo.delete(repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Usuario no encontrado")));
    }
}
