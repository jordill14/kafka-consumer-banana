package com.tfm.kafkaconsumerbanana.application.dto;

import com.tfm.kafkaconsumerbanana.domain.model.User;

public class ResponseTokenData {

    private String message;

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    private User user;

    public ResponseTokenData(String message, User user) {
        this.message = message;
        this.user = user;
    }
}
