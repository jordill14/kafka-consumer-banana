package com.tfm.kafkaconsumerbanana.infrastructure.rest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .disableRedirectHandling()
                .disableContentCompression()
                .build();
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(10000);
        clientHttpRequestFactory.setReadTimeout(5000);
        clientHttpRequestFactory.setHttpClient(httpClient);

        return new RestTemplate(clientHttpRequestFactory);
    }
}
