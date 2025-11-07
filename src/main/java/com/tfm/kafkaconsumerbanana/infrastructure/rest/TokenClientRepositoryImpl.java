package com.tfm.kafkaconsumerbanana.infrastructure.rest;

import com.google.gson.Gson;
import com.tfm.kafkaconsumerbanana.application.dto.ResponseTokenData;
import com.tfm.kafkaconsumerbanana.domain.ports.out.TokenClientRepository;
import com.tfm.kafkaconsumerbanana.domain.model.TokenData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Component
public class TokenClientRepositoryImpl implements TokenClientRepository {

    private final RestTemplate restTemplate;

    public TokenClientRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public String getToken(TokenData tokenData) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TokenData> entity = new HttpEntity<TokenData>(tokenData,headers);

        String endpoint = "http://localhost:3000/users/login";

        ResponseEntity<String> response;
        try {
            response = this.restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Cannot get the response from {}", endpoint, e);
            throw e;
        }

        if(Objects.requireNonNull(response.getBody()).isEmpty()){
            return "";
        }

        String responseBody= response.getBody();
        Gson g = new Gson();
        ResponseTokenData json = g.fromJson(responseBody, ResponseTokenData.class);
        String accessToken = json.getUser().getAccessToken();

        return accessToken;

    }
}
