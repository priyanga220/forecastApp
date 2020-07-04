package com.dbs.weather.forecastApp.dto.darkskyData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "time",
        "summary",
        "icon",
        "sunriseTime",
        "sunsetTime",
        "moonPhase",
        "precipIntensity",
        "precipIntensityMax",
        "precipIntensityMaxTime",
        "precipProbability",
        "precipType",
        "temperatureHigh",
        "temperatureHighTime",
        "temperatureLow",
        "temperatureLowTime",
        "apparentTemperatureHigh",
        "apparentTemperatureHighTime",
        "apparentTemperatureLow",
        "apparentTemperatureLowTime",
        "dewPoint",
        "humidity",
        "pressure",
        "windSpeed",
        "windGust",
        "windGustTime",
        "windBearing",
        "cloudCover",
        "uvIndex",
        "uvIndexTime",
        "visibility",
        "ozone",
        "temperatureMin",
        "temperatureMinTime",
        "temperatureMax",
        "temperatureMaxTime",
        "apparentTemperatureMin",
        "apparentTemperatureMinTime",
        "apparentTemperatureMax",
        "apparentTemperatureMaxTime"
})
@Getter
@Setter
public class ForecastData {

    @JsonProperty("time")
    private Long time;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("sunriseTime")
    private Long sunriseTime;
    @JsonProperty("sunsetTime")
    private Long sunsetTime;
    @JsonProperty("moonPhase")
    private Double moonPhase;
    @JsonProperty("precipIntensity")
    private Double precipIntensity;
    @JsonProperty("precipIntensityMax")
    private Double precipIntensityMax;
    @JsonProperty("precipIntensityMaxTime")
    private Integer precipIntensityMaxTime;
    @JsonProperty("precipProbability")
    private Double precipProbability;
    @JsonProperty("precipType")
    private String precipType;
    @JsonProperty("temperatureHigh")
    private Double temperatureHigh;
    @JsonProperty("temperatureHighTime")
    private Integer temperatureHighTime;
    @JsonProperty("temperatureLow")
    private Double temperatureLow;
    @JsonProperty("temperatureLowTime")
    private Integer temperatureLowTime;
    @JsonProperty("apparentTemperatureHigh")
    private Double apparentTemperatureHigh;
    @JsonProperty("apparentTemperatureHighTime")
    private Integer apparentTemperatureHighTime;
    @JsonProperty("apparentTemperatureLow")
    private Double apparentTemperatureLow;
    @JsonProperty("apparentTemperatureLowTime")
    private Integer apparentTemperatureLowTime;
    @JsonProperty("dewPoint")
    private Double dewPoint;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("windSpeed")
    private Double windSpeed;
    @JsonProperty("windGust")
    private Double windGust;
    @JsonProperty("windGustTime")
    private Integer windGustTime;
    @JsonProperty("windBearing")
    private Integer windBearing;
    @JsonProperty("cloudCover")
    private Double cloudCover;
    @JsonProperty("uvIndex")
    private Integer uvIndex;
    @JsonProperty("uvIndexTime")
    private Integer uvIndexTime;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("ozone")
    private Double ozone;
    @JsonProperty("temperatureMin")
    private Double temperatureMin;
    @JsonProperty("temperatureMinTime")
    private Integer temperatureMinTime;
    @JsonProperty("temperatureMax")
    private Double temperatureMax;
    @JsonProperty("temperatureMaxTime")
    private Integer temperatureMaxTime;
    @JsonProperty("apparentTemperatureMin")
    private Double apparentTemperatureMin;
    @JsonProperty("apparentTemperatureMinTime")
    private Integer apparentTemperatureMinTime;
    @JsonProperty("apparentTemperatureMax")
    private Double apparentTemperatureMax;
    @JsonProperty("apparentTemperatureMaxTime")
    private Integer apparentTemperatureMaxTime;
}