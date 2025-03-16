package com.weather.gateway.services.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class WeatherResponse {

    @JsonProperty("queryCost")
    private int queryCost;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("resolvedAddress")
    private String resolvedAddress;

    @JsonProperty("address")
    private String address;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("tzoffset")
    private double tzOffset;

    @JsonProperty("days")
    private List<Day> days;

    @JsonProperty("stations")
    private Map<String, Station> stations;

    @Data
    public static class Day {
        @JsonProperty("datetime")
        private String datetime;

        @JsonProperty("datetimeEpoch")
        private long datetimeEpoch;

        @JsonProperty("tempmax")
        private double tempMax;

        @JsonProperty("tempmin")
        private double tempMin;

        @JsonProperty("temp")
        private double temp;

        @JsonProperty("feelslikemax")
        private double feelsLikeMax;

        @JsonProperty("feelslikemin")
        private double feelsLikeMin;

        @JsonProperty("feelslike")
        private double feelsLike;

        @JsonProperty("dew")
        private double dew;

        @JsonProperty("humidity")
        private double humidity;

        @JsonProperty("precip")
        private double precip;

        @JsonProperty("precipprob")
        private double precipProb;

        @JsonProperty("precipcover")
        private double precipCover;

        @JsonProperty("preciptype")
        private List<String> precipType;

        @JsonProperty("snow")
        private double snow;

        @JsonProperty("snowdepth")
        private double snowDepth;

        @JsonProperty("windgust")
        private double windGust;

        @JsonProperty("windspeed")
        private double windSpeed;

        @JsonProperty("winddir")
        private double windDir;

        @JsonProperty("pressure")
        private double pressure;

        @JsonProperty("cloudcover")
        private double cloudCover;

        @JsonProperty("visibility")
        private double visibility;

        @JsonProperty("solarradiation")
        private double solarRadiation;

        @JsonProperty("solarenergy")
        private double solarEnergy;

        @JsonProperty("uvindex")
        private double uvIndex;

        @JsonProperty("severerisk")
        private double severerisk;

        @JsonProperty("sunrise")
        private String sunrise;

        @JsonProperty("sunriseEpoch")
        private long sunriseEpoch;

        @JsonProperty("sunset")
        private String sunset;

        @JsonProperty("sunsetEpoch")
        private long sunsetEpoch;

        @JsonProperty("moonphase")
        private double moonPhase;

        @JsonProperty("conditions")
        private String conditions;

        @JsonProperty("description")
        private String description;

        @JsonProperty("icon")
        private String icon;

        @JsonProperty("stations")
        private List<String> stations;

        @JsonProperty("source")
        private String source;
    }

    @Data
    public static class Station {
        @JsonProperty("distance")
        private double distance;

        @JsonProperty("latitude")
        private double latitude;

        @JsonProperty("longitude")
        private double longitude;

        @JsonProperty("useCount")
        private int useCount;

        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("quality")
        private int quality;

        @JsonProperty("contribution")
        private double contribution;
    }
}