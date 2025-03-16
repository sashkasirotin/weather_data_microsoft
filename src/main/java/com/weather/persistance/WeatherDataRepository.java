//package com.weather.persistance;
//
//import com.weather.persistance.model.WeatherDataEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class WeatherDataRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public WeatherDataRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void saveWeatherData(WeatherDataEntity weatherData) {
//        String sql = """
//            INSERT INTO weather_data (
//                city, country, date, temp_max, temp_min, temp_avg, humidity,
//                precip, precip_prob, wind_speed, wind_dir, pressure, cloud_cover,
//                visibility, solar_radiation, uv_index, conditions, description, icon
//            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
//            """;
//
//        jdbcTemplate.update(
//                sql,
//                weatherData.getCity(),
//                weatherData.getCountry(),
//                weatherData.getDate(),
//                weatherData.getTempMax(),
//                weatherData.getTempMin(),
//                weatherData.getTempAvg(),
//                weatherData.getHumidity(),
//                weatherData.getPrecip(),
//                weatherData.getPrecipProb(),
//                weatherData.getWindSpeed(),
//                weatherData.getWindDir(),
//                weatherData.getPressure(),
//                weatherData.getCloudCover(),
//                weatherData.getVisibility(),
//                weatherData.getSolarRadiation(),
//                weatherData.getUvIndex(),
//                weatherData.getConditions(),
//                weatherData.getDescription(),
//                weatherData.getIcon()
//        );
//    }
//
//    public List<WeatherDataEntity> findAll() {
//        String sql = "SELECT * FROM weather_data";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            WeatherDataEntity entity = new WeatherDataEntity();
//            entity.setId(rs.getLong("id"));
//            entity.setCity(rs.getString("city"));
//            entity.setCountry(rs.getString("country"));
//            entity.setDate(rs.getDate("date").toLocalDate());
//            entity.setTempMax(rs.getDouble("temp_max"));
//            entity.setTempMin(rs.getDouble("temp_min"));
//            entity.setTempAvg(rs.getDouble("temp_avg"));
//            entity.setHumidity(rs.getDouble("humidity"));
//            entity.setPrecip(rs.getDouble("precip"));
//            entity.setPrecipProb(rs.getDouble("precip_prob"));
//            entity.setWindSpeed(rs.getDouble("wind_speed"));
//            entity.setWindDir(rs.getDouble("wind_dir"));
//            entity.setPressure(rs.getDouble("pressure"));
//            entity.setCloudCover(rs.getDouble("cloud_cover"));
//            entity.setVisibility(rs.getDouble("visibility"));
//            entity.setSolarRadiation(rs.getDouble("solar_radiation"));
//            entity.setUvIndex(rs.getDouble("uv_index"));
//            entity.setConditions(rs.getString("conditions"));
//            entity.setDescription(rs.getString("description"));
//            entity.setIcon(rs.getString("icon"));
//            return entity;
//        });
//    }
//
//
//
//
//
//
//}
//
