package com.tfm.kafkaconsumerbanana.application.services;

import com.tfm.kafkaconsumerbanana.domain.ports.in.GetTokenUseCase;
import com.tfm.kafkaconsumerbanana.domain.services.TokenClientGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class GetToken implements GetTokenUseCase {

    private final TokenClientGenerator tokenClientGenerator;

    public GetToken(TokenClientGenerator tokenClientGenerator) {
        this.tokenClientGenerator = tokenClientGenerator;
    }

    @Override
    public String execute() {
        return tokenClientGenerator.execute();
    }
}
