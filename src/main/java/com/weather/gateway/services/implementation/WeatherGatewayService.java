package com.weather.gateway.services.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.weather.gateway.mapper.WeatherDataMapper;
import com.weather.gateway.services.delegate.implementation.WeatherGatewayClient;
//import com.weather.gateway.services.delegate.implementation.WeatherGatewayController;
import com.weather.gateway.services.models.WeatherResponse;
//import com.weather.persistance.WeatherDataRepository;
//import com.weather.persistance.model.WeatherDataEntity;
import com.weather.persistance.WeatherDataRepository;
import com.weather.weatherData.gateway.interfaces.IWeatherGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WeatherGatewayService implements IWeatherGatewayService {

    @Autowired
    private WeatherDataRepository weatherDataRepository;
    @Autowired
    private WeatherGatewayClient weatherApiClient;


    public WeatherResponse getWeatherData(String location, String startDate, String endDate) {
        try {
            String weatherJson = weatherApiClient.getWeatherData(location, startDate, endDate);
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponse weatherResponse = objectMapper.readValue(weatherJson, WeatherResponse.class);
            saveWeatherResponse(weatherResponse);
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
            saveWeatherResponse(weatherResponse);
            return weatherResponse;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }


    public void saveWeatherResponse(WeatherResponse weatherResponse) {
        // Save weather stations
        weatherDataRepository.saveStations(weatherResponse.getStations());
        for (WeatherResponse.Day day : weatherResponse.getDays()) {
            for (String stationId : day.getStations()) {  // Some days have multiple station IDs
                weatherDataRepository.saveWeatherData(stationId, List.of(day));
            }
        }
    }

}

