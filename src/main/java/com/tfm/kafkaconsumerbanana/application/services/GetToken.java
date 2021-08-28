package com.tfm.kafkaconsumerbanana.application.services;

import com.tfm.kafkaconsumerbanana.domain.services.TokenClientGenerator;
import org.springframework.stereotype.Service;

@Service
public class GetToken {

    private final TokenClientGenerator tokenClientGenerator;

    public GetToken(TokenClientGenerator tokenClientGenerator) {
        this.tokenClientGenerator = tokenClientGenerator;
    }

    public String execute() {
        return tokenClientGenerator.execute();
    }
}
