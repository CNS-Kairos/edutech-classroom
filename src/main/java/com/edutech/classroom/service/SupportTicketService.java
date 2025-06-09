package com.edutech.classroom.service;

import com.edutech.classroom.dto.SupportTicketDTO;
import com.edutech.classroom.entity.SupportTicket;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.SupportTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportTicketService {
    private final SupportTicketRepository repo;

    public List<SupportTicketDTO> findAll() {
        return repo.findAll().stream().map(SupportTicketDTO::fromEntity).toList();
    }

    public SupportTicketDTO findById(Integer id) {
        return SupportTicketDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket de soporte no encontrado")));
    }

    public SupportTicketDTO create(SupportTicketDTO dto) {
        return SupportTicketDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public SupportTicketDTO update(Integer id,SupportTicketDTO dto) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket de soporte no encontrado"));
        SupportTicket entity = dto.toEntity();
        entity.setId(id);
        return SupportTicketDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        repo.delete(repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket de soporte no encontrado")));
    }
}
