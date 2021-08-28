package com.tfm.kafkaconsumerbanana.domain;

import com.tfm.kafkaconsumerbanana.domain.model.BananaBoxData;

public interface BananaClientRepository {

    void addDataToBanana(BananaBoxData bananaBoxData, String token);
}
