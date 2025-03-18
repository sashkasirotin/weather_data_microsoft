package com.weather.gateway.services.delegate.implementation;
import com.weather.gateway.services.delegate.interfaces.IWeatherGatewayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

    @Service
    public class WeatherGatewayClient implements IWeatherGatewayClient {

        @Value("${weather.api.key}")
        private String apiKey;
        @Value("${weather.api.unitGroup}")
        private String unitGroup;
        @Value("${weather.api.contentType}")
        private String contentType;
        @Value("${weather.api.url}")
        private String apiUrl;

        @Autowired
        private RestTemplate restTemplate;

        @Override
        public String getWeatherData(String location, String startDate, String endDate) {
            String url = apiUrl + "/timeline/" + location + "/" + startDate + "/" + endDate + "?key=" + apiKey + "&unitGroup="+ unitGroup+"&contentType="+contentType+"&include=days";
            System.out.println(url);
            return restTemplate.getForObject(url, String.class);
        }
        @Override
        public String getWeatherData(String location) {
            String url = apiUrl + "/timeline/" + location+"/today" + "?key=" + apiKey + "&unitGroup="+ unitGroup+"&contentType="+contentType+"&include=days";
            System.out.println(url);
            return restTemplate.getForObject(url, String.class);
        }
    }

