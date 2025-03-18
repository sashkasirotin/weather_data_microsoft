package com.weather.resources.delegate.implementations;

import com.weather.gateway.services.models.WeatherResponse;
import com.weather.services.implementations.WeatherDataTodayApplicationService;
import com.weather.services.interfaces.IWeatherDataHistoryApplicationService;
import com.weather.services.interfaces.IWeatherDataTodayApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Weather API", description = "Endpoints for weather data retrieval")
@RestController
@RequestMapping("/weather/fetch")

public class WeatherDataTodayController {
    @Autowired
    private IWeatherDataTodayApplicationService weatherDataTodayApplicationService;
   @Autowired
   private IWeatherDataHistoryApplicationService weatherDataHistoryApplicationService;


    @Operation(summary = "Get Weather Data", description = "Retrieves weather data for a given city")
    @GetMapping("/today")
    public WeatherResponse fetchWeatherData(
            @RequestParam String location) {

        return weatherDataTodayApplicationService.execute(location);

    }
    @Operation(summary = "Get Weather History Data", description = "Retrieves weather data for a given city by range of dates")

    @GetMapping("/history")
    public WeatherResponse fetchWeatherData(
            @RequestParam String location,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return weatherDataHistoryApplicationService.execute(location, startDate, endDate);
    }
}
