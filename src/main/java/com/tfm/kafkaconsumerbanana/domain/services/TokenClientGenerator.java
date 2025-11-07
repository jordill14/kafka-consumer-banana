package com.tfm.kafkaconsumerbanana.domain.services;

import com.tfm.kafkaconsumerbanana.domain.ports.out.TokenClientRepository;
import com.tfm.kafkaconsumerbanana.domain.model.TokenData;


public class TokenClientGenerator {

    private final TokenClientRepository tokenClientRepository;

    public TokenClientGenerator(TokenClientRepository tokenClientRepository) {
        this.tokenClientRepository = tokenClientRepository;
    }

    public String execute() {
        return tokenClientRepository.getToken(new TokenData("banana@banana.com","Admin123$"));
    }
}
