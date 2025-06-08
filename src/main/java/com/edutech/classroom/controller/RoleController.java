package com.edutech.classroom.controller;

import com.edutech.classroom.dto.RoleDTO;
import com.edutech.classroom.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor

public class RoleController {
    private final RoleService service;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findByID(id));
    }

    @PostMapping
    public ResponseEntity<RoleDTO> create(@RequestBody @Valid RoleDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> update(@RequestBody Integer id, @Valid @RequestBody RoleDTO dto){
        return ResponseEntity.ok(service.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
