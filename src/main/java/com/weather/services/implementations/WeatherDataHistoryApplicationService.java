package com.weather.services.implementations;

import com.weather.gateway.services.models.WeatherResponse;
import com.weather.services.interfaces.IWeatherDataHistoryApplicationService;
import com.weather.services.steps.implementations.HistoryWeatherStep;
import org.springframework.beans.factory.annotation.Autowired;

public class WeatherDataHistoryApplicationService implements IWeatherDataHistoryApplicationService {

    @Autowired
    public HistoryWeatherStep historyWeatherStep;
    @Override
    public WeatherResponse execute(String location, String startDate, String endDate){

        return historyWeatherStep.getHistoryWeatherData(location,startDate,endDate);

    }
}
