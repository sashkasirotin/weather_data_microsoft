package com.weather.gateway.services.step.interfaces;

import com.weather.gateway.services.models.WeatherResponse;

public interface ISaveResponseStep {

    void saveWeatherResponse(WeatherResponse weatherResponse);
}
