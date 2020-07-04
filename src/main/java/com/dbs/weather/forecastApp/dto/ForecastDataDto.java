package com.dbs.weather.forecastApp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ForecastDataDto {

    private String code;
    private String location;
    private String icon;
    private String sunriseTime;
    private String sunsetTime;
    private String temperatureHigh;
    private String temperatureLow;
    private String summary;
}
