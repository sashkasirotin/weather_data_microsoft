package com.weather.persistence.services.interfaces;

import com.weather.gateway.services.models.WeatherResponse;

import java.util.List;
import java.util.Map;

public interface IWeatherDataRepository {
    void saveStations(Map<String, WeatherResponse.Station> stations);

    void saveWeatherData(String stationId, List<WeatherResponse.Day> days);
}
