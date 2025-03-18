package com.weather.services.steps.implementations;

import com.weather.gateway.services.models.WeatherResponse;
import com.weather.services.gateway.interfaces.IWeatherGatewayService;
import com.weather.services.steps.interfaces.ITodayWeatherStep;
import org.springframework.beans.factory.annotation.Autowired;

public class TodayWeatherStep implements ITodayWeatherStep {
    @Autowired
    public IWeatherGatewayService weatherGatewayService;
    @Override
    public WeatherResponse getTodayWeatherData(String location) {
        try {
            return weatherGatewayService.getWeatherData(location);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }

}
