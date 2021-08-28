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
            String temperature=splitMessage[1];
        //    temperature=temperature.replace('.',',');
            String humidity=splitMessage[2];
         //   humidity=humidity.replace('.',',');
            String latitude=splitMessage[3];
        //    latitude=latitude.replace('.',',');
            String longitude=splitMessage[4];
          //  longitude=longitude.replace('.',',');
            BananaBoxData bananaBoxData = new BananaBoxData(splitMessage[0],Double.parseDouble(temperature),Double.parseDouble(humidity),Double.parseDouble(latitude),Double.parseDouble(longitude),splitMessage[5]);

            bananaClientRepository.addDataToBanana(bananaBoxData,token);
        }
    }
}