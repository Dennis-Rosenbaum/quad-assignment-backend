package quad.assignmentbackend.trivia.externalmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public record TriviaResponse(
        @JsonProperty("response_code") Integer responseCode,
        TriviaQuestion[] results) {

    public static TriviaResponse fromJson(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, TriviaResponse.class);
    }
}