package com.dbs.weather.forecastApp.service;

import com.dbs.weather.forecastApp.dto.ForecastDataDto;

import java.util.List;

public interface ForecastService {
    List<ForecastDataDto> retrieveLatestForecast();
}
