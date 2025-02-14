package quad.assignmentbackend.trivia.models;
import quad.assignmentbackend.trivia.TriviaQuestionType;

public record TriviaQuestion(
        TriviaQuestionType questionType,
        String difficulty,
        String category,
        String questionId,
        String question,
        TriviaAnswer[] answers) {
}
