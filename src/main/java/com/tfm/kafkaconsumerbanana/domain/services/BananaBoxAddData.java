package com.tfm.kafkaconsumerbanana.domain.services;

import com.tfm.kafkaconsumerbanana.domain.BananaClientRepository;
import com.tfm.kafkaconsumerbanana.domain.model.BananaBoxData;
import org.springframework.stereotype.Component;

@Component
public class BananaBoxAddData {

    private final BananaClientRepository bananaClientRepository;

    public BananaBoxAddData(BananaClientRepository bananaClientRepository) {
        this.bananaClientRepository = bananaClientRepository;
    }

    public void addDataToBanana(String message, String token) {

        String separator = ",";
        String[] splitMessage = message.split(separator);
        if (splitMessage.length == 6) {
            String json = "{\"bananaName\":\"" + splitMessage[0] + "\",\"temperature\":\"" + splitMessage[1] +
                    "\",\"humidity\":\"" + splitMessage[2] + "\",\"latitude\":\"" + splitMessage[3] +
                    "\",\"longitude\":\"" + splitMessage[4] + "\",\"date\":\"" + splitMessage[5] + "\"}";

            BananaBoxData bananaBoxData = BananaBoxData.builder()
                    .bananaName(splitMessage[0])
                    .temperature(Long.parseLong(splitMessage[1]))
                    .humidity(Long.parseLong(splitMessage[2]))
                    .latitude(Long.parseLong(splitMessage[3]))
                    .longitude(Long.parseLong(splitMessage[4]))
                    .date(splitMessage[5]).build();

            bananaClientRepository.addDataToBanana(bananaBoxData,token);
        }
    }
}