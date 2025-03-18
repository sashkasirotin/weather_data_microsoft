package com.weather.gateway.services.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getQueryCost() {
        return queryCost;
    }

    public void setQueryCost(int queryCost) {
        this.queryCost = queryCost;
    }

    public String getResolvedAddress() {
        return resolvedAddress;
    }

    public void setResolvedAddress(String resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }

    public Map<String, Station> getStations() {
        return stations;
    }

    public void setStations(Map<String, Station> stations) {
        this.stations = stations;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getTzOffset() {
        return tzOffset;
    }

    public void setTzOffset(double tzOffset) {
        this.tzOffset = tzOffset;
    }


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

        public double getCloudCover() {
            return cloudCover;
        }

        public void setCloudCover(double cloudCover) {
            this.cloudCover = cloudCover;
        }

        public String getConditions() {
            return conditions;
        }

        public void setConditions(String conditions) {
            this.conditions = conditions;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public long getDatetimeEpoch() {
            return datetimeEpoch;
        }

        public void setDatetimeEpoch(long datetimeEpoch) {
            this.datetimeEpoch = datetimeEpoch;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getDew() {
            return dew;
        }

        public void setDew(double dew) {
            this.dew = dew;
        }

        public double getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(double feelsLike) {
            this.feelsLike = feelsLike;
        }

        public double getFeelsLikeMax() {
            return feelsLikeMax;
        }

        public void setFeelsLikeMax(double feelsLikeMax) {
            this.feelsLikeMax = feelsLikeMax;
        }

        public double getFeelsLikeMin() {
            return feelsLikeMin;
        }

        public void setFeelsLikeMin(double feelsLikeMin) {
            this.feelsLikeMin = feelsLikeMin;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public double getMoonPhase() {
            return moonPhase;
        }

        public void setMoonPhase(double moonPhase) {
            this.moonPhase = moonPhase;
        }

        public double getPrecip() {
            return precip;
        }

        public void setPrecip(double precip) {
            this.precip = precip;
        }

        public double getPrecipCover() {
            return precipCover;
        }

        public void setPrecipCover(double precipCover) {
            this.precipCover = precipCover;
        }

        public double getPrecipProb() {
            return precipProb;
        }

        public void setPrecipProb(double precipProb) {
            this.precipProb = precipProb;
        }

        public List<String> getPrecipType() {
            return precipType;
        }

        public void setPrecipType(List<String> precipType) {
            this.precipType = precipType;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public double getSevererisk() {
            return severerisk;
        }

        public void setSevererisk(double severerisk) {
            this.severerisk = severerisk;
        }

        public double getSnow() {
            return snow;
        }

        public void setSnow(double snow) {
            this.snow = snow;
        }

        public double getSnowDepth() {
            return snowDepth;
        }

        public void setSnowDepth(double snowDepth) {
            this.snowDepth = snowDepth;
        }

        public double getSolarEnergy() {
            return solarEnergy;
        }

        public void setSolarEnergy(double solarEnergy) {
            this.solarEnergy = solarEnergy;
        }

        public double getSolarRadiation() {
            return solarRadiation;
        }

        public void setSolarRadiation(double solarRadiation) {
            this.solarRadiation = solarRadiation;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public List<String> getStations() {
            return stations;
        }

        public void setStations(List<String> stations) {
            this.stations = stations;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public long getSunriseEpoch() {
            return sunriseEpoch;
        }

        public void setSunriseEpoch(long sunriseEpoch) {
            this.sunriseEpoch = sunriseEpoch;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public long getSunsetEpoch() {
            return sunsetEpoch;
        }

        public void setSunsetEpoch(long sunsetEpoch) {
            this.sunsetEpoch = sunsetEpoch;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getTempMax() {
            return tempMax;
        }

        public void setTempMax(double tempMax) {
            this.tempMax = tempMax;
        }

        public double getTempMin() {
            return tempMin;
        }

        public void setTempMin(double tempMin) {
            this.tempMin = tempMin;
        }

        public double getUvIndex() {
            return uvIndex;
        }

        public void setUvIndex(double uvIndex) {
            this.uvIndex = uvIndex;
        }

        public double getVisibility() {
            return visibility;
        }

        public void setVisibility(double visibility) {
            this.visibility = visibility;
        }

        public double getWindDir() {
            return windDir;
        }

        public void setWindDir(double windDir) {
            this.windDir = windDir;
        }

        public double getWindGust() {
            return windGust;
        }

        public void setWindGust(double windGust) {
            this.windGust = windGust;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }
    }


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

        public double getContribution() {
            return contribution;
        }

        public void setContribution(double contribution) {
            this.contribution = contribution;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public int getUseCount() {
            return useCount;
        }

        public void setUseCount(int useCount) {
            this.useCount = useCount;
        }
    }
}
