package com.dbs.weather.forecastApp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Builder
@Document()
public class LocationModel {

    @Id
    private String id;

    private String code;

    private List<WeatherForecastModel> forecasts;

}
