package com.weather.exe;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
		"com.weather.weatherData"
})
@OpenAPIDefinition(info = @Info(title = "Weather API", version = "1.0", description = "Fetch and analyze weather data"))
public class WeatherDataApplication {
	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(WeatherDataApplication.class, args);
	}

}
