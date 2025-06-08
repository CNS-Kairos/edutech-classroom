package com.edutech.classroom.service;

import com.edutech.classroom.dto.DiscountCouponDTO;
import com.edutech.classroom.entity.DiscountCoupon;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.DiscountCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountCouponService {

    private final DiscountCouponRepository repo;

    public List<DiscountCouponDTO> findAll() {
        return repo.findAll().stream().map(DiscountCouponDTO::fromEntity).toList();
    }

    public DiscountCouponDTO findById(Integer id) {
        return DiscountCouponDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cupon no encontrado")));
    }

    public DiscountCouponDTO create(DiscountCouponDTO dto) {
        return DiscountCouponDTO.fromEntity(repo.save(dto.toEntity()));
    }

    public DiscountCouponDTO update(Integer id, DiscountCouponDTO dto) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cupon no encontrado"));
        DiscountCoupon entity = dto.toEntity();
        entity.setId(id);
        return DiscountCouponDTO.fromEntity(repo.save(entity));
    }
    public void delete(Integer id) {
        repo.delete(repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cupon no encontrado")));
    }
}
