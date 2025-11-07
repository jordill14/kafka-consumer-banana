package com.tfm.kafkaconsumerbanana.domain.ports.out;

import com.tfm.kafkaconsumerbanana.domain.model.BananaBoxData;

public interface BananaClientRepository {

    void addDataToBanana(BananaBoxData bananaBoxData, String token);
}
