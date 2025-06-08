package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseContent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.sql.Update;

@Data
public class CourseContentDTO {
    private Integer id;

    @NotNull(message = "El id del curso no puede estar vacio")
    private Integer courseId;

    @Size(max = 200, message = "El titulo no puede superar los 200 caracteres")
    @NotBlank(message = "El titulo no puede estar vacio")
    private String title;

    @Size(max = 50, message = "El tipo de contenido no puede superar los 50 caracteres")
    @NotBlank(message = "El tipo de contenido no puede estar vacio")
    private String contentType;

    @Size(max = 800, message = "La URL del coursecontent no puede superar los 800 caracteres")
    @NotBlank(message = "La URL no debe estar vacia")
    private String url;

    @NotNull(message = "El order index no debe estar vacio")
    private Integer orderIndex;

    public static CourseContentDTO fromEntity(CourseContent entity) {
        CourseContentDTO dto = new CourseContentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setTitle(entity.getTitle());
        dto.setContentType(entity.getContentType());
        dto.setUrl(entity.getUrl());
        dto.setOrderIndex(entity.getOrderIndex());
        return dto;
    }

    public CourseContent fromEntity() {
        CourseContent entity = new CourseContent();
        entity.setId(this.id);
        entity.setTitle(this.title);
        entity.setContentType(this.contentType);
        entity.setUrl(this.url);
        entity.setOrderIndex(this.orderIndex);
        return entity;
    }
}
