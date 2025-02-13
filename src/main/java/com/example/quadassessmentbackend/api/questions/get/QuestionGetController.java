package com.example.quadassessmentbackend.api.questions.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QuestionGetController {

    private final QuestionGetService service;

    @Autowired
    public QuestionGetController(QuestionGetService service) {
        this.service = service;
    }

    @GetMapping("/questions")
    public List<QuestionModel> getQuestions(@RequestParam(required = false) Optional<Integer> count) {

        return service.getQuestions(count.orElse(1));
    }
}
