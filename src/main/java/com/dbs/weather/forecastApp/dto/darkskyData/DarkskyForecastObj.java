package com.dbs.weather.forecastApp.dto.darkskyData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "latitude",
        "longitude",
        "timezone",
        "daily",
        "offset"
})
@Getter
@Setter
public class DarkskyForecastObj {

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("daily")
    private DailyForecast daily;

    @JsonProperty("offset")
    private Integer offset;
}