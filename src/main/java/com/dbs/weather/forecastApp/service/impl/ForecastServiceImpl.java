package com.dbs.weather.forecastApp.service.impl;

import com.dbs.weather.forecastApp.dto.ForecastDataDto;
import com.dbs.weather.forecastApp.service.ForecastService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ForecastServiceImpl implements ForecastService {

    public List<ForecastDataDto> retrieveLatestForecast() {
        return IntStream.range(0, 5).mapToObj(i -> ForecastDataDto.builder().location("AA " + i).forecast("forecast " + i).build()).collect(Collectors.toList());
    }
}
