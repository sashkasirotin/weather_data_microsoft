package com.weather.services.implementations;

import com.weather.gateway.services.models.WeatherResponse;
import com.weather.services.interfaces.IWeatherDataTodayApplicationService;
import com.weather.services.steps.implementations.TodayWeatherStep;
import org.springframework.beans.factory.annotation.Autowired;

public class WeatherDataTodayApplicationService implements IWeatherDataTodayApplicationService {
    @Autowired
    TodayWeatherStep todayWeatherStep;
    @Override
    public WeatherResponse execute(String location){

        return todayWeatherStep.getTodayWeatherData(location);

    }
}
