package quad.assignmentbackend.trivia.models;

import quad.assignmentbackend.utils.HashUtil;

public record TriviaAnswer(
        String answerId,
        String answer) {

    public static TriviaAnswer fromAnswer(String answer) {
        // answerId should be a hashed version of the answer
        // This way we don't have to store the answerId
        String hashedAnswer = HashUtil.hashForId(answer);
        return new TriviaAnswer(hashedAnswer, answer);
    }
}
