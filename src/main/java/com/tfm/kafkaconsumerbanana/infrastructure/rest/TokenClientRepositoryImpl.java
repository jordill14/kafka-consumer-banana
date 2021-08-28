package com.tfm.kafkaconsumerbanana.infrastructure.rest;

import com.google.gson.Gson;
import com.tfm.kafkaconsumerbanana.application.dto.ResponseTokenData;
import com.tfm.kafkaconsumerbanana.domain.TokenClientRepository;
import com.tfm.kafkaconsumerbanana.domain.model.TokenData;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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

        ResponseEntity<String> response = this.restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);
        String responseBody= response.getBody();
        Gson g = new Gson();
        ResponseTokenData json = g.fromJson(responseBody, ResponseTokenData.class);
        String accessToken = json.getUser().getAccessToken();
        System.out.println(accessToken);
        return accessToken;
       // return Objects.requireNonNull(response.getBody()).getUser().getAccessToken();
    }
}
