package com.tfm.kafkaconsumerbanana.domain.services;

import com.tfm.kafkaconsumerbanana.domain.TokenClientRepository;
import com.tfm.kafkaconsumerbanana.domain.model.TokenData;
import org.springframework.stereotype.Component;

@Component
public class TokenClientGenerator {

    private final TokenClientRepository tokenClientRepository;

    public TokenClientGenerator(TokenClientRepository tokenClientRepository) {
        this.tokenClientRepository = tokenClientRepository;
    }

    public String execute() {
        return tokenClientRepository.getToken(new TokenData("banana@banana.com","Admin123$"));
    }
}
