package com.tfm.kafkaconsumerbanana.domain.services;

import com.tfm.kafkaconsumerbanana.domain.BananaClientRepository;
import com.tfm.kafkaconsumerbanana.domain.model.BananaBoxData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BananaBoxAddData {

    private final BananaClientRepository bananaClientRepository;

    public BananaBoxAddData(BananaClientRepository bananaClientRepository) {
        this.bananaClientRepository = bananaClientRepository;
    }

    public void addDataToBanana(String message, String token) {

        String separator = null;

        try {
            separator = ",";
            String[] splitMessage = message.split(separator);

            if (splitMessage.length == 6) {

                String temperature = splitMessage[1];
                String humidity = splitMessage[2];
                String latitude = splitMessage[3];
                String longitude = splitMessage[4];

                BananaBoxData bananaBoxData =
                        new BananaBoxData(splitMessage[0], Double.parseDouble(temperature), Double.parseDouble(humidity), Double.parseDouble(latitude), Double.parseDouble(longitude), splitMessage[5]);
                bananaClientRepository.addDataToBanana(bananaBoxData, token);
            } else {
                log.error("Missing data to build BananaBoxData");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



