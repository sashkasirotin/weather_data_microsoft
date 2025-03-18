package com.weather.services.steps.interfaces;

import com.weather.gateway.services.models.WeatherResponse;

public interface IHistoryWeatherStep {
    WeatherResponse getHistoryWeatherData(String location, String startDate, String endDate);
}
