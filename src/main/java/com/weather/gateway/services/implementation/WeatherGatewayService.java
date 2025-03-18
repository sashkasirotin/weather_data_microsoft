package com.weather.gateway.services.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.gateway.services.delegate.implementation.WeatherGatewayClient;
import com.weather.gateway.services.models.WeatherResponse;
import com.weather.gateway.services.step.interfaces.ISaveResponseStep;
import com.weather.persistence.services.interfaces.IWeatherDataRepository;
import com.weather.services.gateway.interfaces.IWeatherGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherGatewayService implements IWeatherGatewayService {

    @Autowired
    private IWeatherDataRepository weatherDataRepository;
    @Autowired
    private WeatherGatewayClient weatherApiClient;
    @Autowired
    private ISaveResponseStep saveResponseStep;


    public WeatherResponse getWeatherData(String location, String startDate, String endDate) {
        try {
            String weatherJson = weatherApiClient.getWeatherData(location, startDate, endDate);
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponse weatherResponse = objectMapper.readValue(weatherJson, WeatherResponse.class);
            saveResponseStep.saveWeatherResponse(weatherResponse);
            return weatherResponse;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }

    public WeatherResponse getWeatherData(String location) {
        try {
            String weatherJson = weatherApiClient.getWeatherData(location);
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponse weatherResponse = objectMapper.readValue(weatherJson, WeatherResponse.class);
            saveResponseStep.saveWeatherResponse(weatherResponse);
            return weatherResponse;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }

}

