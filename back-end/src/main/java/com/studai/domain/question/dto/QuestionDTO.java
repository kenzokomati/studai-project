package com.studai.domain.question.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.studai.domain.question.QuestionType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {

    private String id;
    private QuestionType questionType;
    private String statement;
    private String hint;
    private String explanation;
    private Object correctAnswer;
    private String quizId;
    private List<String> options;

    public boolean isCorrectAnswer(Object answer) {
        if (answer == null || correctAnswer == null) {
            return false;
        }

        return switch (questionType) {
            case MULTIPLE_CHOICE, TRUE_OR_FALSE ->
                correctAnswer.equals(answer);
            default -> throw new UnsupportedOperationException("QuestionType not supported yet: " + questionType);
        };
    }

}
