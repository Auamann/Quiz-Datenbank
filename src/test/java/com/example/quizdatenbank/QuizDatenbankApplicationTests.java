package com.example.quizdatenbank;

import com.example.quizdatenbank.Question.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuizDatenbankApplicationTests {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void integrationsTest() {
        Question question1 = new Question("Frage 1", "Antwort 1");
        Question question2 = new Question("Frage 2", "Antwort 2");
        question1.setApproved(true);
        question2.setApproved(true);

        ResponseEntity<Question[]> emptyResponse = restTemplate.getForEntity("/api/questions", Question[].class);
        assertThat(emptyResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(emptyResponse.getBody()).isEmpty();

        ResponseEntity<Question> postResponse = restTemplate.postForEntity("/api/questions", question1, Question.class);
        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse.getBody().getFrage()).isEqualTo("Frage 1");

        ResponseEntity<Question> postResponse2 = restTemplate.postForEntity("/api/questions", question2, Question.class);
        assertThat(postResponse2.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse2.getBody().getFrage()).isEqualTo("Frage 2");

        ResponseEntity<Question[]> fullResponse = restTemplate.getForEntity("/api/questions", Question[].class);
        assertThat(fullResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(fullResponse.getBody().length).isEqualTo(2);


    }

}
