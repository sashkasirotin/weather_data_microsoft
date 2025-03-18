package com.weather.services.steps.interfaces;

import com.weather.gateway.services.models.WeatherResponse;

public interface ITodayWeatherStep {
    WeatherResponse getTodayWeatherData(String location);
}
