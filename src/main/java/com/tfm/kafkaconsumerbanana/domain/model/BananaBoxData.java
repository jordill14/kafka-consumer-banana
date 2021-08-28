package com.tfm.kafkaconsumerbanana.domain.model;


public class BananaBoxData {

    private final String bananaName;
    private final Double temperature;
    private final Double humidity;
    private final Double latitude;
    private final Double longitude;
    private final String date;


    public BananaBoxData(String bananaName, Double temperature, Double humidity, Double latitude, Double longitude, String date) {
        this.bananaName = bananaName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
    }

    public String getBananaName() {
        return bananaName;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getDate() {
        return date;
    }
}
