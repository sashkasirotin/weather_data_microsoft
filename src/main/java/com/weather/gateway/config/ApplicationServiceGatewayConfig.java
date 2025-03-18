package com.weather.gateway.config;

import com.weather.gateway.services.delegate.implementation.WeatherGatewayClient;
import com.weather.gateway.services.delegate.interfaces.IWeatherGatewayClient;
import com.weather.gateway.services.step.implemantation.SaveResponseStep;
import com.weather.gateway.services.step.interfaces.ISaveResponseStep;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@AutoConfiguration
public class ApplicationServiceGatewayConfig {
    @Bean
    private ISaveResponseStep saveResponseStep(){
        return new SaveResponseStep();
    }
    @Bean
    public IWeatherGatewayClient weatherGatewayClient(){
        return new WeatherGatewayClient();
    }
}
