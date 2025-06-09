package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.CourseQuizQuestion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseQuizQuestionDTO {
    private Integer id;

    @NotNull(message = "El id del quiz no puede estar vacio")
    private Integer quizId;

    @Size(max = 800, message = "La pregunta no puede superar los 800 caracteres")
    private String questionText;

    @Size(max = 800, message = "La descripcion no puede superar los 800 caracteres")
    private String optionA;

    @Size(max = 800, message = "La descripcion no puede superar los 800 caracteres")
    private String optionB;

    @Size(max = 800, message = "La descripcion no puede superar los 800 caracteres")
    private String optionC;

    @Size(max = 800, message = "La descripcion no puede superar los 800 caracteres")
    private String optionD;

    @Size(max = 800, message = "La descripcion no puede superar los 800 caracteres")
    private String optionE;

    @Size(max = 800, message = "La descripcion no puede superar los 800 caracteres")
    private String correctAnswer;

    @Size(max = 1)
    private String correctOption;

    @NotNull(message = "El orderIndex No debe estar vacio")
    private Integer orderIndex;

    @NotNull(message = "La fecha de creacion no debe estar vacia")
    private Instant createdAt;

    public static CourseQuizQuestionDTO fromEntity(CourseQuizQuestion entity) {
        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        dto.setId(entity.getId());
        dto.setQuizId(entity.getQuiz().getId());
        dto.setQuestionText(entity.getQuestionText());
        dto.setOptionA(entity.getOptionA());
        dto.setOptionB(entity.getOptionB());
        dto.setOptionC(entity.getOptionC());
        dto.setOptionD(entity.getOptionD());
        dto.setOptionE(entity.getOptionE());
        dto.setCorrectAnswer(entity.getCorrectAnswer());
        dto.setCorrectOption(entity.getCorrectOption());
        dto.setOrderIndex(entity.getOrderIndex());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public CourseQuizQuestion toEntity() {
        CourseQuizQuestion entity = new CourseQuizQuestion();
        entity.setId(this.getId());

        CourseQuiz courseQuiz = new CourseQuiz();
        courseQuiz.setId(this.getQuizId());
        entity.setQuiz(courseQuiz);

        entity.setQuestionText(this.getQuestionText());
        entity.setOptionA(this.getOptionA());
        entity.setOptionB(this.getOptionB());
        entity.setOptionC(this.getOptionC());
        entity.setOptionD(this.getOptionD());
        entity.setOptionE(this.getOptionE());
        entity.setCorrectAnswer(this.getCorrectAnswer());
        entity.setCorrectOption(this.getCorrectOption());
        entity.setOrderIndex(this.getOrderIndex());
        entity.setCreatedAt(this.getCreatedAt());
        return entity;
    }
}
