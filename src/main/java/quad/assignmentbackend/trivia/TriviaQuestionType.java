package quad.assignmentbackend.trivia;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TriviaQuestionType {
    @JsonProperty("multiple") MultipleChoice,
    @JsonProperty("boolean") TrueFalse
}
