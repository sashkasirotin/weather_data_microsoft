package com.weather.weatherData.config;

import com.weather.gateway.services.delegate.implementation.WeatherGatewayClient;
import com.weather.gateway.services.implementation.WeatherGatewayService;
import com.weather.weatherData.gateway.interfaces.IWeatherGatewayService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@AutoConfiguration
public class ApplicationServiceConfig {
    @Bean
    public IWeatherGatewayService weatherGatewayService(){
        return new WeatherGatewayService();
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public WeatherGatewayClient weatherGatewayClient(){
        return new WeatherGatewayClient();
    }
}
