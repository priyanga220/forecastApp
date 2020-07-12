package com.dbs.weather.forecastApp.dao;

import java.time.LocalDate;

public interface CustomLocationRepository {
    void removeForecastByDate(LocalDate date);
}
