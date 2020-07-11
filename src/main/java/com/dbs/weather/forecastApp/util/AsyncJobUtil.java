package com.dbs.weather.forecastApp.util;


import com.dbs.weather.forecastApp.dao.LocationRepository;
import com.dbs.weather.forecastApp.dto.ForecastDataDto;
import com.dbs.weather.forecastApp.model.LocationModel;
import com.dbs.weather.forecastApp.model.WeatherForecastModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AsyncJobUtil {

    private static final Logger logger = LoggerFactory.getLogger(AsyncJobUtil.class);

    @Autowired
    private LocationRepository locationRepository;

    @Async
    public void cacheForecasts(List<ForecastDataDto> forecastDtos) {
        if (!CollectionUtils.isEmpty(forecastDtos)) {
            LocalDate currentDate = LocalDate.now();
            forecastDtos.stream().forEach(fcDto -> {
                        logger.info("Caching started for location : {}", fcDto.getLocation());
                        LocationModel locationModel = null;
                        Optional<LocationModel> locationModelObj = locationRepository.findByCode(fcDto.getCode());
                        if (locationModelObj.isPresent()) {
                            locationModel = locationModelObj.get();

                        } else {
                            locationModel = LocationModel.builder().code(fcDto.getCode()).build();
                        }

                        if (CollectionUtils.isEmpty(locationModel.getForecasts())) {
                            locationModel.setForecasts(new ArrayList<WeatherForecastModel>());
                        }
                        locationModel.getForecasts().add(WeatherForecastModel.builder().
                                date(currentDate)
                                .summary(fcDto.getSummary())
                                .icon(fcDto.getIcon())
                                .sunriseTime(fcDto.getSunriseTime())
                                .sunsetTime(fcDto.getSunsetTime())
                                .temperatureHigh(String.valueOf(fcDto.getTemperatureHigh()))
                                .temperatureLow(String.valueOf(fcDto.getTemperatureLow())).build());

                        locationRepository.save(locationModel);
                        logger.info("Caching done for location : {}", fcDto.getLocation());
                    }
            );
        }
    }


    //Run the Housekeeping Job everyday at 00:01AM in background (ss mm hh * Month DayOfWeek)
    //Remove Forecast data prior than 3 days from MongoDB
    @Scheduled(cron = "0 1 0 * * ?")
    @Async
    public void houseKeepOldCache() {
        logger.info("Housekeeping for Old forecasts started");
        List<LocationModel> cachedForecats = locationRepository.findAll();
        cachedForecats.forEach(cachedFc -> cachedFc.getForecasts().removeIf(fc -> fc.getDate().isBefore(LocalDate.now().minusDays(2))));
        locationRepository.saveAll(cachedForecats);
        logger.info("Housekeeping for Old forecasts finished");
    }
}
