package com.edutech.classroom.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseQuizDTO {
    private Integer id;

    @NotNull(message = "El id del curso no puede estar vacio")
    private Integer courseId;

    @Size(max = 150, message = "El titulo del curso no puede superar los 150 caracteres")
    @NotNull(message = "El titulo del curso no puede estar vacio")
    private String title;

    @Size(max = 800, message = "La descripcion del curso no puede superar los 800 caracteres")
    private String description;

    @Size(max = 50, message = "El tipo de curso no puede superar los 50 caracteres")
    private String quizType;

    private Instant createdAt;
}
