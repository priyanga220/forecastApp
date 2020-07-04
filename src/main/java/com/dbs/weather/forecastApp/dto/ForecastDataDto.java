package com.dbs.weather.forecastApp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ForecastDataDto {

    private String location;
    private String forecast;
}
