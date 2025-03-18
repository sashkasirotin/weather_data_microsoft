package com.weather.exe;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
		"com.weather.weatherData"
})
public class WeatherDataApplication {
	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(WeatherDataApplication.class, args);
	}

}
