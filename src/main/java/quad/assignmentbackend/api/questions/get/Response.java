package quad.assignmentbackend.api.questions.get;

import quad.assignmentbackend.trivia.TriviaQuestionType;

public record Response(
        String questionId,
        TriviaQuestionType questionType,
        String question,
        ResponseAnswer[] answers) {
}