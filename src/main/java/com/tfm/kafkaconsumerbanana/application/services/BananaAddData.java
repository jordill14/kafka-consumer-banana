package com.tfm.kafkaconsumerbanana.application.services;

import com.tfm.kafkaconsumerbanana.domain.ports.in.AddBannaDataUseCase;
import com.tfm.kafkaconsumerbanana.domain.services.BananaBoxAddData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BananaAddData implements AddBannaDataUseCase {

    private final BananaBoxAddData bananaBoxAddData;

    public BananaAddData(BananaBoxAddData bananaBoxAddData) {
        this.bananaBoxAddData = bananaBoxAddData;
    }
    @Override
    public void execute(String message, String token) {
        try {
            bananaBoxAddData.addDataToBanana(message, token);
        } catch (IllegalArgumentException  e) {
            log.error("Error processing banana message: {}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("Unexpected error processing banana message", e);
        }
    }
}
