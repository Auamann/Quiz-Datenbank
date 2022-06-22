package com.example.quizdatenbank.Interfaces;

import com.example.quizdatenbank.Question.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends MongoRepository <Questions, String> {

    List<Questions> findAllByApproved(boolean approvalStatus);

}
