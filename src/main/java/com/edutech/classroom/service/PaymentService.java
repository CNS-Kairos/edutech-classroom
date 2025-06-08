package com.edutech.classroom.service;

import com.edutech.classroom.dto.PaymentDTO;
import com.edutech.classroom.entity.Payment;
import com.edutech.classroom.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PaymentService {
    private final PaymentRepository repo;

    public List<PaymentDTO> findAll(){
        return repo.findAll().stream().map(PaymentDTO::fromEntity).toList();
    }

    public PaymentDTO findById(Integer id){
        return PaymentDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pago no encontrado")));
    }

    public PaymentDTO create(PaymentDTO dto){
        return PaymentDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public PaymentDTO update(Integer id, PaymentDTO dto){
        repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Pago no encontrado"));
        Payment entity = dto.toEntity();
        entity.setId(id);
        return PaymentDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id){
        repo.delete(repo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Pago no encontrado")));
    }
}
