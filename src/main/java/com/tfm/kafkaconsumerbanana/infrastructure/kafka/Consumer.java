package com.tfm.kafkaconsumerbanana.infrastructure.kafka;

import com.tfm.kafkaconsumerbanana.application.services.BananaAddData;
import com.tfm.kafkaconsumerbanana.application.services.GetToken;
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
    public Consumer(GetToken getToken, BananaAddData bananaAddData) {
        this.getToken = getToken;
        this.bananaAddData = bananaAddData;
    }

    private final GetToken getToken;
    private final BananaAddData bananaAddData;

    @KafkaListener(topics = "banana", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));

        String token = getToken.execute();
        bananaAddData.execute(message,token);



    }

}
