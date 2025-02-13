package com.example.quadassessmentbackend.api.checkanswers.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Request {

    @NotNull(message = "Question ID is required")
    private Integer questionId;

    @NotNull(message = "Answer is required")
    private String answer;

    public Integer getQuestionId() {
        return questionId;
    }

    public String getAnswer() {
        return answer;
    }
}