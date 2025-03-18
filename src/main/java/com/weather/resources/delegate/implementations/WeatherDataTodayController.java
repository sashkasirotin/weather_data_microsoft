package com.weather.resources.delegate.implementations;

import com.weather.gateway.services.models.WeatherResponse;
import com.weather.services.implementations.WeatherDataTodayApplicationService;
import com.weather.services.interfaces.IWeatherDataTodayApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather/fetch")
public class WeatherDataTodayController {
    @Autowired
    private IWeatherDataTodayApplicationService weatherDataTodayApplicationService;

    @GetMapping("/today")
    public WeatherResponse fetchWeatherData(
            @RequestParam String location) {

        return weatherDataTodayApplicationService.execute(location);

    }
}
