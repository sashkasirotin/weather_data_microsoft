package com.weather.gateway.services.delegate.interfaces;

public interface IWeatherGatewayClient {
    String getWeatherData(String location, String startDate, String endDate);

    String getWeatherData(String location);
}
