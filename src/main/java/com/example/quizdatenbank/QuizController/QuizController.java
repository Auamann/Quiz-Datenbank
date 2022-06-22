package com.example.quizdatenbank.QuizController;

import com.example.quizdatenbank.Question.Questions;
import com.example.quizdatenbank.QuizService.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor

public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public List<Questions> getQuestions() {
        return quizService.getApprovedQuestions();
    }

    @GetMapping("{id}")
    public ResponseEntity<Questions> getQuestion(@PathVariable String id) {
        return ResponseEntity.of(quizService.getQuestion(id));
    }
    @PostMapping
    public Questions createQuestion(@RequestBody Questions question) {
        return quizService.createQuestion(question);
    }
}

