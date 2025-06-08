package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Role;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class UserDTO {

    private Integer id;

    @NotBlank(message = "El primer nombre no puede estar vacio")
    @Size(max = 100, message = "El primer nombre tiene un máximo de 100 caracteres")
    private String firstName;

    @NotBlank(message = "El apellido no puede estar vacio")
    @Size(max = 100, message = "El apellido tiene un máximo de 100 caracteres")
    private String lastName;

    @NotBlank(message = "El email no puede estar vacio")
    @Size(max = 255, message = "El email tiene un máximo de 255 caracteres")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacio")
    @Size(max = 255, message = "La contraseña tiene un máximo de 255 caracteres")
    private String passwordHash;

    @NotNull(message = "El rol no puede estar vacio")
    private Integer roleId;

    @NotNull(message = "El estado no puede estar vacio")
    private Boolean isActive;

    @NotNull
    private Instant createdAt;

    @NotNull
    private Instant updatedAt;

    public static UserDTO fromEntity(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPasswordHash(entity.getPasswordHash());

        dto.setRoleId(entity.getRole().getId());

        dto.setIsActive(entity.getIsActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public User toEntity() {
        User entity = new User();
        entity.setId(this.getId());
        entity.setFirstName(this.getFirstName());
        entity.setLastName(this.getLastName());
        entity.setEmail(this.getEmail());
        entity.setPasswordHash(this.getPasswordHash());

        Role role = new Role();
        role.setId(this.getRoleId());
        entity.setRole(role);

        entity.setIsActive(this.getIsActive());
        entity.setCreatedAt(this.getCreatedAt());
        entity.setUpdatedAt(this.getUpdatedAt());
        return entity;
    }
}
