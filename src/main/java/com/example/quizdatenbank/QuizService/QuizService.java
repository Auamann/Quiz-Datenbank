package com.example.quizdatenbank.QuizService;

import com.example.quizdatenbank.Interfaces.QuizRepository;
import com.example.quizdatenbank.Question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public List<Question> getApprovedQuestions() {
    return quizRepository.findAllByApproved(true);

    }

    public Question createQuestion(Question question) {
        return quizRepository.save(question);
    }

    public Optional<Question> getQuestion(String id) {
        return quizRepository.findById(id);
    }
}