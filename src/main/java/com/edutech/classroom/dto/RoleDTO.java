package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoleDTO {

    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(max=50, message = "Nombre máximo de 50 caracteres")
    private String name;

    @NotBlank(message = "La descripción no puede estar vacia")
    @Size(max = 800, message = "La descripción tiene un máximo de 800 caratecteres")
    private String description;

    public static RoleDTO fromEntity(Role entity) {
        RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public Role toEntity() {
        Role entity = new Role();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setDescription(this.getDescription());
        return entity;
    }
}
