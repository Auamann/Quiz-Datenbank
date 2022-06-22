package com.example.quizdatenbank.QuizService;

import com.example.quizdatenbank.Interfaces.QuizRepository;
import com.example.quizdatenbank.Question.Questions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public List<Questions> getApprovedQuestions() {
    return quizRepository.findAllByApproved(true);

    }

    public Questions createQuestion(Questions question) {
        return quizRepository.save(question);
    }

    public Optional<Questions> getQuestion(String id) {
        return quizRepository.findById(id);
    }
}