package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Enrollment;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class EnrollmentDTO {
    private Integer id;

    @NotNull(message = "El id del estudiante no puede estar vacio")
    private Integer studentId;

    @NotNull(message = "El id del curso no puede estar vacio")
    private Integer courseId;

    @NotNull(message = "La fecha de enrolamiento no puede estar vacia")
    private Instant enrolledAt;

    @NotNull(message = "El status no puede estar vacio")
    @Size(max = 20, message = "El status no puede superar los 20 caracteres")
    private String status;

    public static EnrollmentDTO fromEntity(Enrollment entity) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(entity.getId());
        dto.setStudentId(entity.getStudent().getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setEnrolledAt(entity.getEnrolledAt());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Enrollment toEntity() {
        Enrollment entity = new Enrollment();
        entity.setId(this.getId());
        entity.setStudentId(this.getStudentId());
        entity.setCourseId(this.getCourseId());
        entity.setEnrolledAt(this.getEnrolledAt());
        entity.setStatus(this.getStatus());
        return entity;
    }
}
