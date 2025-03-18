package com.weather.services.steps.implementations;

import com.weather.gateway.services.models.WeatherResponse;
import com.weather.services.gateway.interfaces.IWeatherGatewayService;
import com.weather.services.steps.interfaces.IHistoryWeatherStep;
import org.springframework.beans.factory.annotation.Autowired;

public class HistoryWeatherStep implements IHistoryWeatherStep {
    @Autowired
    private IWeatherGatewayService weatherService;
    @Override
    public WeatherResponse getHistoryWeatherData(String location, String startDate, String endDate) {
        try {
            return weatherService.getWeatherData(location, startDate, endDate);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }
}
