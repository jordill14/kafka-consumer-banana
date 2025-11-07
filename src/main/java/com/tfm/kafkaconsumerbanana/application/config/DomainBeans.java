package com.tfm.kafkaconsumerbanana.application.config;

import com.tfm.kafkaconsumerbanana.domain.ports.out.BananaClientRepository;
import com.tfm.kafkaconsumerbanana.domain.ports.out.TokenClientRepository;
import com.tfm.kafkaconsumerbanana.domain.services.BananaBoxAddData;
import com.tfm.kafkaconsumerbanana.domain.services.TokenClientGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DomainBeans {


    private final BananaClientRepository bananaClientRepository;
    private final TokenClientRepository tokenClientRepository;

    @Bean
    public BananaBoxAddData bananaBoxAddData() {
        return new BananaBoxAddData(bananaClientRepository);
    }

    @Bean
    public TokenClientGenerator tokenClientGenerator(){
        return new TokenClientGenerator(tokenClientRepository);
    }

}
