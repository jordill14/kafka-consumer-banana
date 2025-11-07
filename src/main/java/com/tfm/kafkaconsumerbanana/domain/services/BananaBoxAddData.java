package com.tfm.kafkaconsumerbanana.domain.services;

import com.tfm.kafkaconsumerbanana.domain.ports.out.BananaClientRepository;
import com.tfm.kafkaconsumerbanana.domain.model.BananaBoxData;


public class BananaBoxAddData {

    private final BananaClientRepository bananaClientRepository;

    public BananaBoxAddData(BananaClientRepository bananaClientRepository) {
        this.bananaClientRepository = bananaClientRepository;
    }

    public void addDataToBanana(String message, String token) {
        if(message == null || message.isBlank()){
            throw new IllegalArgumentException("Message cannot be null or empty");
        }

        String[] splitMessage = message.split(",");

        if(splitMessage.length != 6) {
            throw new IllegalArgumentException("Invalid message format: expected 6 fields, got \" + splitMessage.length");
        }
        try {

            String temperature = splitMessage[1];
            String humidity = splitMessage[2];
            String latitude = splitMessage[3];
            String longitude = splitMessage[4];

            BananaBoxData bananaBoxData =
                    new BananaBoxData(splitMessage[0], Double.parseDouble(temperature), Double.parseDouble(humidity), Double.parseDouble(latitude), Double.parseDouble(longitude), splitMessage[5]);
            bananaClientRepository.addDataToBanana(bananaBoxData, token);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric value in message: " + message, e);
        }
    }
}



