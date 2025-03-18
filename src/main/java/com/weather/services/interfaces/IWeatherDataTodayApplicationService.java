package com.weather.services.interfaces;

import com.weather.gateway.services.models.WeatherResponse;

public interface IWeatherDataTodayApplicationService {
    WeatherResponse execute(String location);
}
