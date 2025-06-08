package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseQuizDTO {
    private Integer id;

    @NotNull(message = "El id del curso no puede estar vacio")
    private Integer courseId;

    @Size(max = 200, message = "El titulo del curso no puede superar los 200 caracteres")
    @NotBlank(message = "El titulo del curso no puede estar vacio")
    private String title;

    @Size(max = 800, message = "La descripcion del curso no puede superar los 800 caracteres")
    @NotBlank(message = "La descripccion no debe estar vacia")
    private String description;

    @Size(max = 50, message = "El tipo de curso no puede superar los 50 caracteres")
    @NotBlank(message = "El quizType no debe estar vacio")
    private String quizType;

    @NotNull(message = "La fecha de creacion no debe estar vacia")
    private Instant createdAt;

    public static CourseQuizDTO fromEntity(CourseQuiz entity) {
        CourseQuizDTO dto = new CourseQuizDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setQuizType(entity.getQuizType());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public CourseQuiz toEntity() {
        CourseQuiz entity = new CourseQuiz();
        entity.setId(this.getId());
        entity.setCourseId(this.getCourseId());
        entity.setTitle(this.getTitle());
        entity.setDescription(this.getDescription());
        entity.setQuizType(this.getQuizType());
        entity.setCreatedAt(this.getCreatedAt());
        return entity;
    }
}
