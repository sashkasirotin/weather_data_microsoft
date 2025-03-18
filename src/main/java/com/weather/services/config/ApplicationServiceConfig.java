package com.weather.services.config;

import com.weather.gateway.services.delegate.implementation.WeatherGatewayClient;
import com.weather.gateway.services.delegate.interfaces.IWeatherGatewayClient;
import com.weather.gateway.services.implementation.WeatherGatewayService;
import com.weather.persistence.services.implementations.WeatherDataRepository;
import com.weather.persistence.services.interfaces.IWeatherDataRepository;
import com.weather.services.gateway.interfaces.IWeatherGatewayService;
import com.weather.services.implementations.WeatherDataHistoryApplicationService;
import com.weather.services.implementations.WeatherDataTodayApplicationService;
import com.weather.services.interfaces.IWeatherDataHistoryApplicationService;
import com.weather.services.interfaces.IWeatherDataTodayApplicationService;
import com.weather.services.steps.implementations.HistoryWeatherStep;
import com.weather.services.steps.implementations.TodayWeatherStep;
import com.weather.services.steps.interfaces.IHistoryWeatherStep;
import com.weather.services.steps.interfaces.ITodayWeatherStep;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
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
    public IWeatherGatewayClient weatherGatewayClient(){
        return new WeatherGatewayClient();
    }
    @Bean
    public IWeatherDataRepository weatherDataRepository(){
        return new WeatherDataRepository();
    }
    @Bean
    public IWeatherDataTodayApplicationService weatherDataTodayApplicationService(){
        return new WeatherDataTodayApplicationService();
    }
    @Bean
    public IWeatherDataHistoryApplicationService weatherDataHistoryApplicationService(){
        return new WeatherDataHistoryApplicationService();
    }
    @Bean
    public IHistoryWeatherStep historyWeatherStep(){return new HistoryWeatherStep();
    }
    @Bean
    public ITodayWeatherStep todayWeatherStep(){return new TodayWeatherStep();
    }

}
