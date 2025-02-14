package quad.assignmentbackend.trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import quad.assignmentbackend.exceptions.ExternalServiceException;
import quad.assignmentbackend.trivia.data.QuestionTableStorageService;
import quad.assignmentbackend.trivia.externalmodels.TriviaResponse;
import quad.assignmentbackend.trivia.models.TriviaAnswer;
import quad.assignmentbackend.trivia.models.TriviaQuestion;
import quad.assignmentbackend.utils.HashUtil;

import java.util.*;

@Service
public class TriviaQuestionsService {

    private final QuestionTableStorageService questionTableStorageService;

    @Autowired
    public TriviaQuestionsService(QuestionTableStorageService questionTableStorageService) {
        this.questionTableStorageService = questionTableStorageService;
    }

    private List<TriviaAnswer> constructAnswers(quad.assignmentbackend.trivia.externalmodels.TriviaQuestion question)
    {
        List<TriviaAnswer> answers = new ArrayList<>();
        for (String answer : question.incorrectAnswers())
            answers.add(TriviaAnswer.fromAnswer(answer));
        answers.add(TriviaAnswer.fromAnswer(question.correctAnswer()));

        Collections.shuffle(answers);
        return answers;
    }

    private void storeCorrectAnswer(quad.assignmentbackend.trivia.externalmodels.TriviaQuestion question)
    {
        String questionId = HashUtil.hashForId(question.question());
        String answerId = HashUtil.hashForId(question.correctAnswer());
        questionTableStorageService.insertEntity(questionId, answerId);
    }

    public List<TriviaQuestion> getQuestions(Integer count) {

        String url = "https://opentdb.com/api.php?amount=" + count;
        TriviaResponse response;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> responseString = client.send(request, HttpResponse.BodyHandlers.ofString());
            response = TriviaResponse.fromJson(responseString.body());
        } catch (Exception e) {
            throw new ExternalServiceException("Failed to get questions", e);
        }

        // convert the result to a models.TriviaQuestion List

        List<TriviaQuestion> triviaQuestions = Arrays.stream(response.results())
                .map(result -> new TriviaQuestion(
                        result.type(),
                        result.difficulty(),
                        result.category(),
                        HashUtil.hashForId(result.question()),
                        result.question(),
                        constructAnswers(result).toArray(new TriviaAnswer[0])
                ))
                .toList();

        for (quad.assignmentbackend.trivia.externalmodels.TriviaQuestion question : response.results())
            storeCorrectAnswer(question);

        return triviaQuestions;
    }

    public Boolean validateAnswer(String questionId, String answerId) {
        return questionTableStorageService.entityExists(questionId, answerId);
    }
}
