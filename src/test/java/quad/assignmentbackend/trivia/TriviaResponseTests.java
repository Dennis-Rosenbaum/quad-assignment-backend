package quad.assignmentbackend.trivia;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import quad.assignmentbackend.trivia.externalmodels.TriviaQuestion;
import quad.assignmentbackend.trivia.externalmodels.TriviaResponse;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TriviaResponseTests {

    @Test
    void convertJsonToTriviaResponse_Expects_CorrectResult() throws Exception {
        String json = """
        {
            "response_code": 0,
            "results": [
                {
                    "type": "multiple",
                    "difficulty": "easy",
                    "category": "General Knowledge",
                    "question": "What is the capital of France?",
                    "correct_answer": "Paris",
                    "incorrect_answers": ["London", "Berlin", "Madrid"]
                }
            ]
        }
        """;

        TriviaResponse response = TriviaResponse.fromJson(json);

        assertNotNull(response);
        assertEquals(0, response.responseCode());
        assertNotNull(response.results());
        assertEquals(1, response.results().length);

        TriviaQuestion question = response.results()[0];
        assertEquals(TriviaQuestionType.MultipleChoice, question.type());
        assertEquals("easy", question.difficulty());
        assertEquals("General Knowledge", question.category());
        assertEquals("What is the capital of France?", question.question());
        assertEquals("Paris", question.correctAnswer());
        assertArrayEquals(new String[]{"London", "Berlin", "Madrid"}, question.incorrectAnswers());
    }


    @Test
    void convertJsonToTriviaResponse_TypeUnknown_Expects_ExceptionThrown() {
        String json = """
        {
            "results": [
                {
                    "type": "unkown"
                }
            ]
        }
        """;

        assertThrows(Exception.class, () -> TriviaResponse.fromJson(json + "invalid"));
    }
}
