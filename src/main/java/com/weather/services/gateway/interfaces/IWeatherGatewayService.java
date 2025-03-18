package com.weather.services.gateway.interfaces;

import com.weather.gateway.services.models.WeatherResponse;

public interface IWeatherGatewayService {
     WeatherResponse getWeatherData(String location, String startDate, String endDate);

     WeatherResponse getWeatherData(String location);
}
