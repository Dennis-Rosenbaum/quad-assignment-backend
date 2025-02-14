package quad.assignmentbackend.api.checkanswers.post;

import jakarta.validation.constraints.NotNull;

public class Request {

    @NotNull(message = "Question ID is required")
    private String questionId;

    @NotNull(message = "Answer ID is required")
    private String answerId;

    public String getQuestionId() {
        return questionId;
    }

    public String getAnswerId() {
        return answerId;
    }
}