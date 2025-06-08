package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseComment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseCommentDTO {
    private Integer id;

    @NotNull
    private Integer courseId;

    @NotNull
    private Integer userId;

    @Size(max = 800, message = "El tamaño maximo del Comentario de texto es de 800 caracteres")
    @NotBlank(message = "El Comentario de texto no debe estar vacio")
    private String commentText;

    @NotNull(message = "El rating no debe estar vacio")
    private Integer rating;

    @NotNull(message = "La fecha de creacion no debe estar vacia")
    private Instant createdAt;

    public static CourseCommentDTO fromEntity(CourseComment entity) {
        CourseCommentDTO dto = new CourseCommentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourseId());
        dto.setUserId(entity.getUserId());
        dto.setCommentText(entity.getCommentText());
        dto.setRating(entity.getRating());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public CourseComment toEntity() {
        CourseComment entity = new CourseComment();
        entity.setId(this.id);
        entity.setCourseId(this.getCourseId());
        entity.setUserId(this.getUserId());
        entity.setCommentText(this.getCommentText());
        entity.setRating(this.getRating());
        entity.setCreatedAt(this.getCreatedAt());
        return entity;
    }
}
