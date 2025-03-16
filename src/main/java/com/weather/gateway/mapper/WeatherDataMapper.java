//package com.weather.gateway.mapper;
//import com.weather.gateway.services.models.WeatherResponse;
//import com.weather.persistance.model.WeatherDataEntity;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//    @Component
//    public class WeatherDataMapper {
//
//        public WeatherDataEntity mapToEntity(WeatherResponse.Day day, String city, String country) {
//            WeatherDataEntity entity = new WeatherDataEntity();
//            entity.setCity(city);
//            entity.setCountry(country);
//            entity.setDate(LocalDate.parse(day.getDatetime(), DateTimeFormatter.ISO_DATE));
//            entity.setTempMax(day.getTempMax());
//            entity.setTempMin(day.getTempMin());
//            entity.setTempAvg(day.getTemp());
//            entity.setHumidity(day.getHumidity());
//            entity.setPrecip(day.getPrecip());
//            entity.setPrecipProb(day.getPrecipProb());
//            entity.setWindSpeed(day.getWindSpeed());
//            entity.setWindDir(day.getWindDir());
//            entity.setPressure(day.getPressure());
//            entity.setCloudCover(day.getCloudCover());
//            entity.setVisibility(day.getVisibility());
//            entity.setSolarRadiation(day.getSolarRadiation());
//            entity.setUvIndex(day.getUvIndex());
//            entity.setConditions(day.getConditions());
//            entity.setDescription(day.getDescription());
//            entity.setIcon(day.getIcon());
//            return entity;
//        }
//    }