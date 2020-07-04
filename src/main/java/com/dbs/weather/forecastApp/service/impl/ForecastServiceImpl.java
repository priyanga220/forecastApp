package com.dbs.weather.forecastApp.service.impl;

import com.dbs.weather.forecastApp.config.LocationConfiguration;
import com.dbs.weather.forecastApp.dto.ForecastDataDto;
import com.dbs.weather.forecastApp.dto.darkskyData.DarkskyForecastObj;
import com.dbs.weather.forecastApp.service.DarkskyApiService;
import com.dbs.weather.forecastApp.service.ForecastService;
import com.dbs.weather.forecastApp.util.ForecastUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ForecastServiceImpl implements ForecastService {

    Logger logger = LoggerFactory.getLogger(ForecastServiceImpl.class);

    @Autowired
    private LocationConfiguration locationConfiguration;

    @Autowired
    private DarkskyApiService darkskyApiService;

    @Override
    public List<ForecastDataDto> retrieveLatestForecast() {
        List<ForecastDataDto> result = new ArrayList<>();
        Map<String, CompletableFuture<DarkskyForecastObj>> forecastFutureObjects = new HashMap<>();

        locationConfiguration.getLocations().forEach((locationKey, location) -> {

            Optional<ForecastDataDto> forecastDtoObj = Optional.empty();

            if (forecastDtoObj.isPresent()) {
                result.add(forecastDtoObj.get());
            } else {
                forecastFutureObjects.put(locationKey, darkskyApiService.fetchForecastForLocation(location.getLocationMatrix()));
                logger.info("Darksky Rest call made for {} ", location.getName());
            }
        });

        if(!CollectionUtils.isEmpty(forecastFutureObjects)) {
            result.addAll(processForecastFutureResults(forecastFutureObjects));
        }
        return result;
    }

    private List<ForecastDataDto> processForecastFutureResults(Map<String, CompletableFuture<DarkskyForecastObj>> forecastFuturesMap) {
        logger.info("Processing Darksky API results");

        CompletableFuture.allOf(forecastFuturesMap.values().toArray(new CompletableFuture[forecastFuturesMap.size()])).join();
        List<ForecastDataDto> forecastDtos = new ArrayList<>();

        forecastFuturesMap.forEach((locationCode, forecastFutureObj) -> {
            try {
                DarkskyForecastObj forecastObj = forecastFutureObj.get();
                forecastDtos.add(ForecastUtil.convertForecastResultToForecastDto(locationCode, locationConfiguration.getLocationByCode(locationCode).getName(), forecastObj));
            } catch (Exception ex) {
                logger.error("Error occurred fetching forecast data from API for location : {}" + locationConfiguration.getLocations().get(locationCode).getName(), ex);
            }
        });
        return forecastDtos;
    }


}
