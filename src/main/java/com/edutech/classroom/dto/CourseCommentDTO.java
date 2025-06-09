package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.entity.User;
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
        dto.setCourseId(entity.getCourse().getId());
        dto.setUserId(entity.getUser().getId());
        dto.setCommentText(entity.getCommentText());
        dto.setRating(entity.getRating());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public CourseComment toEntity() {
        CourseComment entity = new CourseComment();
        entity.setId(this.id);

        Course course = new Course();
        course.setId(this.courseId);
        entity.setCourse(course);

        User user = new User();
        user.setId(this.userId);
        entity.setUser(user);

        entity.setCommentText(this.getCommentText());
        entity.setRating(this.getRating());
        entity.setCreatedAt(this.getCreatedAt());
        return entity;
    }
}
