package com.example.quadassessmentbackend.api.questions.get;

import java.util.Dictionary;
import java.util.List;
import java.util.Arrays;

@org.springframework.stereotype.Service
public class QuestionGetService {

    //todo: place somewhere in a database
    private Dictionary<Integer, String> questions;

    public List<QuestionModel> getQuestions(int count) {
        //todo: call https://opentdb.com/api.php?amount=10
        //todo: convert the result to a QuestionModel (randomize the answers)
        //todo: store the correct answersanswers


        List<QuestionModel> result = Arrays.asList(
                new QuestionModel(1, QuestionType.MultipleChoice, "In the cartoon &#039;SpongeBob SquarePants&#039;, what did the acronym E.V.I.L stand for?",
                        new String[]{
                                "Every Villain Is Lemons",
                                "Every Villain Is Lemonade",
                                "Every Villain Is Limes",
                                "Each Villain Is Lemonade"
                        }),
                new QuestionModel(2, QuestionType.TrueFalse, "Linux was first created as an alternative to Windows XP.",
                        new String[]{
                                "True",
                                "False"
                        }),new QuestionModel(1, QuestionType.MultipleChoice, "In the cartoon &#039;SpongeBob SquarePants&#039;, what did the acronym E.V.I.L stand for?",
                new String[]{
                        "Every Villain Is Lemons",
                        "Every Villain Is Lemonade",
                        "Every Villain Is Limes",
                        "Each Villain Is Lemonade"
                }),
                new QuestionModel(2, QuestionType.TrueFalse, "Linux was first created as an alternative to Windows XP.",
                        new String[]{
                                "True",
                                "False"
                        })
        );

        List<QuestionModel> limitedResults = result.subList(0, Math.min(count, result.size()));

        return limitedResults;
    }
}
