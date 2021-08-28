package com.tfm.kafkaconsumerbanana.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class BananaBoxData {

    private final String bananaName;
    private final Long temperature;
    private final Long humidity;
    private final Long latitude;
    private final Long longitude;
    private final String date;

}
