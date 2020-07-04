package com.dbs.weather.forecastApp.service;

import com.dbs.weather.forecastApp.dto.darkskyData.DarkskyForecastObj;

import java.util.concurrent.CompletableFuture;

public interface DarkskyApiService {

    CompletableFuture<DarkskyForecastObj> fetchForecastForLocation(String locationMatrix);

}
