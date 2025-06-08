package com.edutech.classroom.controller;


import com.edutech.classroom.dto.DiscountCouponDTO;
import com.edutech.classroom.service.DiscountCouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount-coupons")
@RequiredArgsConstructor

public class DiscountCouponController {
    private final DiscountCouponService service;

    @GetMapping
    public ResponseEntity<List<DiscountCouponDTO>> findAll()  {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCouponDTO> findById(@PathVariable Integer id)  {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DiscountCouponDTO> create(@RequestBody @Valid DiscountCouponDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCouponDTO> update(@PathVariable Integer id,@Valid @RequestBody DiscountCouponDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
