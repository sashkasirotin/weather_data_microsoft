package com.weather.services.interfaces;

import com.weather.gateway.services.models.WeatherResponse;

public interface IWeatherDataHistoryApplicationService {
    WeatherResponse execute(String location, String startDate, String endDate);
}
