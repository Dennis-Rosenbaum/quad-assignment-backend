package quad.assignmentbackend.trivia.externalmodels;
import com.fasterxml.jackson.annotation.JsonProperty;
import quad.assignmentbackend.trivia.TriviaQuestionType;

public record TriviaQuestion(
        TriviaQuestionType type,
        String difficulty,
        String category,
        String question,
        @JsonProperty("correct_answer") String correctAnswer,
        @JsonProperty("incorrect_answers") String[] incorrectAnswers
) {
}
