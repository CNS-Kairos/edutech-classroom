package com.edutech.classroom.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.edutech.classroom.entity.Course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseDTO {

    private Integer id;

    @Size(max = 200, message= "El tamaño maximo del titulo es de 200 caracteres")
    @NotBlank(message= "El titulo del curso no puede estar vacio")
    private String title;

    @Size(max = 800, message= "EL tamaño maximo de la descripcion es de 800 caracteres")
    @NotBlank(message= "La descripcion del curso no puede estar vacia")
    private String description;

    @NotNull(message= "La categoria del curso no puede estar vacia")
    private Integer categoryId;

    @NotNull(message = "El manager del curso no puede estar vacio")
    private Integer managerId;

    @NotNull(message = "El Instructor del curso no puede estar vacio")
    private Integer instructorId;

    @NotNull(message = "La fecha de publicacion del curso no puede estar vacia")
    private LocalDate publishDate;

    @NotNull(message = "El precio del curso no puede estar vacio")
    private BigDecimal price;

    @Size(max = 255, message= "El tamaño maximo de la URL de la imagen es de 255 caracteres")
    @NotBlank(message= "La URL no puede estar vacia")
    private String image;

    @Size(max = 50, message= "El tamaño maximo del status es de 50 caracteres")
    @NotBlank(message= "El Status no puede estar vacio")
    private String status;

    public static CourseDTO fromEntity(Course entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setCategoryId(entity.getCategory().getId());
        dto.setManagerId(entity.getManager().getId());
        dto.setInstructorId(entity.getInstructor().getId());
        dto.setPublishDate(entity.getPublishDate());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Course toEntity() {
        Course entity = new Course();
        entity.setId(this.getId());
        entity.setTitle(this.getTitle());
        entity.setDescription(this.getDescription());
        entity.setCategoryId(this.getCategoryId());
        entity.setManagerId(this.getManagerId());
        entity.setInstructorId(this.getInstructorId());
        entity.setPublishDate(this.getPublishDate());
        entity.setPrice(this.getPrice());
        entity.setImage(this.getImage());
        entity.setStatus(this.getStatus());
        return entity;
    }
}