package com.tfm.kafkaconsumerbanana.infrastructure.kafka;

import com.tfm.kafkaconsumerbanana.domain.ports.in.AddBannaDataUseCase;
import com.tfm.kafkaconsumerbanana.domain.ports.in.GetTokenUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    public Consumer(GetTokenUseCase getTokenUseCase, AddBannaDataUseCase addBannaDataUseCase) {
        this.getTokenUseCase = getTokenUseCase;
        this.addBannaDataUseCase = addBannaDataUseCase;
    }

    private final GetTokenUseCase getTokenUseCase;
    private final AddBannaDataUseCase addBannaDataUseCase;

    @KafkaListener(topics = "banana", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));

        String token = getTokenUseCase.execute();
        addBannaDataUseCase.execute(message,token);



    }

}
