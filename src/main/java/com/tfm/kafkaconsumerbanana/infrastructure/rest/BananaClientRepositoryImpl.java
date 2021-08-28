package com.tfm.kafkaconsumerbanana.infrastructure.rest;

import com.tfm.kafkaconsumerbanana.domain.BananaClientRepository;
import com.tfm.kafkaconsumerbanana.domain.model.BananaBoxData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class BananaClientRepositoryImpl implements BananaClientRepository {
    private final RestTemplate restTemplate;

    public BananaClientRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public void addDataToBanana(BananaBoxData bananaBoxData, String token) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<BananaBoxData> entity = new HttpEntity<BananaBoxData>(bananaBoxData,headers);

        String endpoint = "https://localhost:8181/bananas/addDataToBanana";

        this.restTemplate.exchange(endpoint, HttpMethod.POST, entity, BananaBoxData.class);

        try {
            this.restTemplate.exchange(endpoint, HttpMethod.POST, entity, BananaBoxData.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Cannot get the response from {}", endpoint, e);
            throw e;
        }
    }
}
