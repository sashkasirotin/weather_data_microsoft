package com.weather.gateway.services.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.weather.gateway.mapper.WeatherDataMapper;
import com.weather.gateway.services.delegate.implementation.WeatherGatewayClient;
//import com.weather.gateway.services.delegate.implementation.WeatherGatewayController;
import com.weather.gateway.services.models.WeatherResponse;
//import com.weather.persistance.WeatherDataRepository;
//import com.weather.persistance.model.WeatherDataEntity;
import com.weather.weatherData.gateway.interfaces.IWeatherGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherGatewayService implements IWeatherGatewayService {

    //@Autowired
   // private WeatherDataRepository weatherDataRepository;
    @Autowired
    private WeatherGatewayClient weatherApiClient;
    //@Autowired
    //private final WeatherDataMapper weatherDataMapper;


    public WeatherResponse getWeatherData(String location, String startDate, String endDate) {
        try {
            String weatherJson = weatherApiClient.getWeatherData(location, startDate, endDate);
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponse weatherResponse = objectMapper.readValue(weatherJson, WeatherResponse.class);
            //saveWeatherData(weatherResponse);
            return weatherResponse;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }

    public WeatherResponse getWeatherData(String location) {
        try {
            String weatherJson = weatherApiClient.getWeatherData(location);
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponse weatherResponse = objectMapper.readValue(weatherJson, WeatherResponse.class);
            //saveWeatherData(weatherResponse);
            return weatherResponse;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }

//    public void saveWeatherData(WeatherResponse weatherResponse) {
//        if (weatherResponse != null && weatherResponse.getDays() != null) {
//            for (WeatherResponse.Day day : weatherResponse.getDays()) {
//                WeatherDataEntity entity = weatherDataMapper.mapToEntity(day);
//                weatherDataRepository.saveWeatherData(entity);
//            }
//        }
//    }


//        public void fetchAndSaveThirtyDaysOldWeatherData(String city,String dateRange) {
//        WeatherResponse weatherResponse = weatherApiClient.getWeatherData(city,dateRange);
//        double temperature = weatherResponse.getMain().getTemp();
//        int humidity = weatherResponse.getMain().getHumidity();
//        //weatherRepository.saveWeatherData(city, "Country", temperature, humidity, LocalDate.now());
//    }
//
//        private double parseTemperature(String weatherJson) {
//            // Implement JSON parsing logic (e.g., using Jackson)
//            // Example: Extract temperature from the JSON response
//            return 25.5; // Replace with actual parsing logic
//        }
//
//        private double parseHumidity(String weatherJson) {
//            // Implement JSON parsing logic (e.g., using Jackson)
//            // Example: Extract humidity from the JSON response
//            return 60.0; // Replace with actual parsing logic
//        }
}

