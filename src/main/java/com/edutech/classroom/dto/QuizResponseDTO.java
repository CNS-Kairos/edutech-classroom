package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.QuizResponse;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.time.Instant;

@Data
public class QuizResponseDTO {
    private Integer id;

    @NotNull (message = "El id del quiz no puede estar vacio")
    private Integer quizId;

    @NotNull (message = "El id del estudiante no puede estar vacio")
    private Integer studentId;

    @Size(max = 1)
    private String selectedOption;

    @NotBlank
    @Size(max = 800, message = "La respuesta al quiz no puede superar los 800 caracteres")
    private String responseContent;

    @NotBlank
    @Size(max = 800, message = "La url de la asignatura no puede superar los 800 caracteres")
    private String assignmentUrl;

    @NotNull
    private Instant submittedAt;

    public static QuizResponseDTO fromEntity(QuizResponse entity) {
        QuizResponseDTO dto = new QuizResponseDTO();
        dto.setId(entity.getId());

        dto.setQuizId(entity.getQuiz().getId());

        dto.setStudentId(entity.getStudent().getId());

        dto.setResponseContent(entity.getResponseContent());
        dto.setAssignmentUrl(entity.getAssignmentUrl());
        dto.setSubmittedAt(entity.getSubmittedAt());
        return dto;
    }

    public QuizResponse toEntity() {
        QuizResponse entity = new QuizResponse();
        entity.setId(this.getId());

        CourseQuiz quiz = new CourseQuiz();
        quiz.setId(this.getQuizId());
        entity.setQuiz(quiz);

        User student = new User();
        student.setId(this.getStudentId());
        entity.setStudent(student);

        entity.setSelectedOption(this.getSelectedOption());
        entity.setResponseContent(this.getResponseContent());
        entity.setAssignmentUrl(this.getAssignmentUrl());
        entity.setSubmittedAt(this.getSubmittedAt());
        return entity;
    }
}
