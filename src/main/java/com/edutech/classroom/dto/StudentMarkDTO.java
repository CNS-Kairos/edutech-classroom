package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.StudentMark;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.math.BigDecimal;
import java.time.Instant;

@Data
public class StudentMarkDTO {

    private Integer id;

    @NotNull(message = "El ID del quiz no puede estar vacío")
    private Integer quizId;

    @NotNull(message = "El ID del estudiante no puede estar vacío")
    private Integer studentId;

    @NotNull(message = "La nota no puede estar vacía")
    private BigDecimal mark;

    @Size(max = 800, message = "Los comentarios tienen un máximo de 800 caracteres")
    private String comments;

    @NotNull(message = "La fecha de calificación no puede estar vacía")
    private Instant gradedAt;

    public static StudentMarkDTO fromEntity(StudentMark entity){
        StudentMarkDTO dto = new StudentMarkDTO();
        dto.setId(entity.getId());
        // Objeto Quiz
        dto.setQuizId(entity.getQuiz().getId());
        // Objeto User
        dto.setStudentId(entity.getStudent().getId());
        dto.setMark(entity.getMark());
        dto.setComments(entity.getComments());
        dto.setGradedAt(entity.getGradedAt());
        return dto;
    }

    public StudentMark toEntity(){
        StudentMark entity = new StudentMark();
        entity.setId(this.getId());

        //Objeto Quiz nuevamente
        CourseQuiz quiz = new CourseQuiz();
        quiz.setId(this.getQuizId());
        entity.setQuiz(quiz);

        //Objeto User, de nuevo
        User user = new User();
        user.setId(this.getStudentId());
        entity.setStudent(user);

        entity.setMark(this.getMark());
        entity.setComments(this.getComments());
        entity.setGradedAt(this.getGradedAt());
        return entity;
    }
}
