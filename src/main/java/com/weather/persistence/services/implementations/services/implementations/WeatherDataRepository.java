package com.weather.persistence.services.implementations;

import com.weather.gateway.services.models.WeatherResponse;
import com.weather.persistence.services.interfaces.IWeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WeatherDataRepository implements IWeatherDataRepository {
    @Autowired
    public JdbcTemplate jdbcTemplate;


    @Override
    public void saveStations(Map<String, WeatherResponse.Station> stations) {
        String sql = "MERGE INTO weather_stations AS target " +
                "USING (SELECT ? AS id, ? AS name, ? AS latitude, ? AS longitude, ? AS quality) AS source " +
                "ON target.id = source.id " +
                "WHEN NOT MATCHED THEN " +
                "INSERT (id, name, latitude, longitude, quality) " +
                "VALUES (source.id, source.name, source.latitude, source.longitude, source.quality);";

        for (WeatherResponse.Station station : stations.values()) {
            jdbcTemplate.update(sql,
                    station.getId(), station.getName(), station.getLatitude(),
                    station.getLongitude(), station.getQuality()
            );
        }
    }
    @Override
    public void saveWeatherData(String stationId, List<WeatherResponse.Day> days) {
        String sql = "MERGE INTO weather_data AS target " +
                "USING (SELECT ? AS station_id, ? AS datetime) AS source " +
                "ON target.station_id = source.station_id AND target.datetime = source.datetime " +
                "WHEN NOT MATCHED THEN " +
                "INSERT (station_id, datetime, temp_max, temp_min, temp_avg, " +
                "feels_like_max, feels_like_min, feels_like_avg, dew_point, humidity, " +
                "precipitation, precip_prob, precip_type, wind_gust, wind_speed, wind_dir, " +
                "pressure, cloud_cover, visibility, solar_radiation, solar_energy, uv_index, " +
                "conditions, description) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        for (WeatherResponse.Day day : days) {
            jdbcTemplate.update(sql,
                    stationId, day.getDatetime(),  // Source table for MERGE
                    stationId, day.getDatetime(), day.getTempMax(), day.getTempMin(), day.getTemp(),
                    day.getFeelsLikeMax(), day.getFeelsLikeMin(), day.getFeelsLike(), day.getDew(),
                    day.getHumidity(), day.getPrecip(), day.getPrecipProb(),
                    (day.getPrecipType() != null ? String.join(",", day.getPrecipType()) : null),
                    day.getWindGust(), day.getWindSpeed(), day.getWindDir(), day.getPressure(),
                    day.getCloudCover(), day.getVisibility(), day.getSolarRadiation(),
                    day.getSolarEnergy(), day.getUvIndex(), day.getConditions(), day.getDescription()
            );
        }
    }




}

