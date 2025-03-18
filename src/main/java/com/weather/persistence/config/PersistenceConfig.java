package com.weather.persistence.config;

import com.weather.persistence.services.implementations.WeatherDataRepository;
import com.weather.persistence.services.interfaces.IWeatherDataRepository;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
@EnableAutoConfiguration
@AutoConfiguration
public class PersistenceConfig {
    @Bean
    private IWeatherDataRepository weatherDataRepository(){
        return new WeatherDataRepository();
    }
}

