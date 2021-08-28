package com.tfm.kafkaconsumerbanana.domain;

import com.tfm.kafkaconsumerbanana.domain.model.TokenData;

public interface TokenClientRepository {
    String getToken(TokenData tokenData);

}
