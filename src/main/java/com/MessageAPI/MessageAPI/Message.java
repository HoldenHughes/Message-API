package com.MessageAPI.MessageAPI;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    private Long id;

    @Column
    private String message;

    // Getters And Setters
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Return a Long for the number of words in String message
    public Long getWordCount(){
        String message = this.message;
        return Arrays.stream(message.split(" ")).count();
    }

}
