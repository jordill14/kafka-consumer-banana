package com.tfm.kafkaconsumerbanana.domain.model;

public class TokenData {

    private String email;
    private String password;

    public TokenData(String token, String password) {
        this.email = token;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
