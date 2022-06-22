package com.example.quizdatenbank;

import com.example.quizdatenbank.Question.Questions;
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
        Questions question1 = new Questions("Frage 1", "Antwort 1");
        Questions question2 = new Questions("Frage 2", "Antwort 2");
        question1.setApproved(true);
        question2.setApproved(true);

        ResponseEntity<Questions[]> emptyResponse = restTemplate.getForEntity("/api/questions", Questions[].class);
        assertThat(emptyResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(emptyResponse.getBody()).isEmpty();

        ResponseEntity<Questions> postResponse = restTemplate.postForEntity("/api/questions", question1, Questions.class);
        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse.getBody().getFrage()).isEqualTo("Frage 1");

        ResponseEntity<Questions> postResponse2 = restTemplate.postForEntity("/api/questions", question2, Questions.class);
        assertThat(postResponse2.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse2.getBody().getFrage()).isEqualTo("Frage 2");

        ResponseEntity<Questions[]> fullResponse = restTemplate.getForEntity("/api/questions", Questions[].class);
        assertThat(fullResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(fullResponse.getBody().length).isEqualTo(2);


    }

}
