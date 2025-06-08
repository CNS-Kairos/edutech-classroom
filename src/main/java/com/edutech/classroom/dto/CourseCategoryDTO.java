package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseCategoryDTO {
    private Integer id;

    @Size(max = 100, message = "El tamaño maximo del nombre de Course category es de 100 caracteres")
    @NotBlank(message = "El nombre del Course Category no puede estar vacio")
    private String name;

    @Size(max = 800, message = "El tamaño maximo de la descripcion del course category es de 800 caracteres")
    @NotNull(message = "La descripcion del curso no puede estar vacia")
    private String description;

    public static CourseCategoryDTO fromEntity(CourseCategory entity) {
        CourseCategoryDTO dto = new CourseCategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public CourseCategory toEntity() {
        CourseCategory entity = new CourseCategory();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setDescription(this.getDescription());
        return entity;
    }
}
