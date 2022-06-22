package com.example.quizdatenbank.Question;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
public class Questions {

    @Id
    private String id;

    public String frage;
    public String antwort;
    private boolean approved;

    public Questions(String frage, String antwort) {
        this.frage = frage;
        this.antwort = antwort;
    }
}
