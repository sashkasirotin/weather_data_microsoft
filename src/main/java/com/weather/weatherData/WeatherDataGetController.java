package com.weather.weatherData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.gateway.services.implementation.WeatherGatewayService;
import com.weather.gateway.services.models.WeatherResponse;
import com.weather.weatherData.gateway.interfaces.IWeatherGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.ApplicationContext;

@RestController
@RequestMapping("/weather/fetch")
public class WeatherDataGetController {


    @Autowired
    private IWeatherGatewayService weatherService;


    @GetMapping("/history")
    public WeatherResponse fetchWeatherData(
            @RequestParam String location,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return getWeatherData(location, startDate, endDate);
    }

    @GetMapping("/today")
    public WeatherResponse fetchWeatherData(
            @RequestParam String location) {
        return getTodayWeatherData(location);
    }

    public WeatherResponse getWeatherData(String location, String startDate, String endDate) {
        try {
            return weatherService.getWeatherData(location, startDate, endDate);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }
    public WeatherResponse getTodayWeatherData(String location) {
        try {
            return weatherService.getWeatherData(location);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }
}

