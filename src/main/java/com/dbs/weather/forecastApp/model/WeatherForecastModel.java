package com.dbs.weather.forecastApp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class WeatherForecastModel {

    @Id
    private String id;

    private LocalDate date;
    private String summary;
    private String icon;
    private String sunriseTime;
    private String sunsetTime;
    private String temperatureHigh;
    private String temperatureLow;

}
