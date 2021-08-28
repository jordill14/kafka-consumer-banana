package com.tfm.kafkaconsumerbanana.domain.model;

public class User {

    public User(String email, String password, String accessToken) {
        this.email = email;
        this.password = password;
        this.accessToken = accessToken;
    }

    private String email;
    private String password;
    private String accessToken;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
