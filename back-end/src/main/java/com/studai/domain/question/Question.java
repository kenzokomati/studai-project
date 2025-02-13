package com.studai.domain.question;


import com.studai.domain.quiz.Quiz;
import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tquestion")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @Column(nullable = false)
    private String statement;

    @Column
    private String hint;

    @Column(nullable = false)
    private String explanation;

    @Column(nullable = false)
    private String correctAnswer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Column(nullable = false)
    private String options = "";

    public List<String> getOptions(){
        return Arrays.asList(options.split(";"));
    }

    public void setOptions(List<String> options) {
        this.options = options == null ? "" : String.join(";", options);
    }

}
