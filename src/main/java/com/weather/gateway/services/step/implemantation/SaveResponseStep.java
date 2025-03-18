package com.weather.gateway.services.step.implemantation;

import com.weather.gateway.services.models.WeatherResponse;
import com.weather.gateway.services.step.interfaces.ISaveResponseStep;
import com.weather.persistence.services.interfaces.IWeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SaveResponseStep implements ISaveResponseStep {
    @Autowired
    private IWeatherDataRepository weatherDataRepository;

    @Override
    public void saveWeatherResponse(WeatherResponse weatherResponse) {
        weatherDataRepository.saveStations(weatherResponse.getStations());
        for (WeatherResponse.Day day : weatherResponse.getDays()) {
            for (String stationId : day.getStations()) {  // Some days have multiple station IDs
                weatherDataRepository.saveWeatherData(stationId, List.of(day));
            }
        }
    }
}
