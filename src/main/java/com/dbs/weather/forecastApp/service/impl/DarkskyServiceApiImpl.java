package com.dbs.weather.forecastApp.service.impl;

import com.dbs.weather.forecastApp.dto.darkskyData.DarkskyForecastObj;
import com.dbs.weather.forecastApp.service.DarkskyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;

@Service
public class DarkskyServiceApiImpl implements DarkskyApiService {

    @Autowired
    private RestTemplate darkskyRestClient;

    @Autowired

    @Value("${darksky.exclude}")
    private String excludeList;

    @Async
    public CompletableFuture<DarkskyForecastObj> fetchForecastForLocation(String locationMatrix) {
        return CompletableFuture.completedFuture(darkskyRestClient.getForObject(this.getFormattedURIEndpoint(locationMatrix), DarkskyForecastObj.class));
    }

    private String getFormattedURIEndpoint(String locationMatrix) {
        return new StringBuilder("/")
                .append(locationMatrix)
                .append(",")
                .append(Instant.now().getEpochSecond())
                .append("?")
                .append("exclude=")
                .append(excludeList)
                .toString();

    }

}
