package com.tfm.kafkaconsumerbanana.application.services;

import com.tfm.kafkaconsumerbanana.domain.services.BananaBoxAddData;
import org.springframework.stereotype.Service;

@Service
public class BananaAddData {

    private final BananaBoxAddData bananaBoxAddData;

    public BananaAddData(BananaBoxAddData bananaBoxAddData) {
        this.bananaBoxAddData = bananaBoxAddData;
    }

    public void execute(String message, String token) {
        bananaBoxAddData.addDataToBanana(message, token);
    }
}
