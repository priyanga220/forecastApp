package com.dbs.weather.forecastApp.util;

import com.dbs.weather.forecastApp.dto.ForecastDataDto;
import com.dbs.weather.forecastApp.dto.darkskyData.DarkskyForecastObj;
import com.dbs.weather.forecastApp.dto.darkskyData.ForecastData;
import com.dbs.weather.forecastApp.model.WeatherForecastModel;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class ForecastUtil {
    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public static ForecastDataDto convertForecastResultToForecastDto(String locationCode, String locationName, DarkskyForecastObj forecastObj) {
        ForecastData data = forecastObj.getDaily().getData().get(0);
        return ForecastDataDto.builder()
                .code(locationCode)
                .location(locationName)
                .summary(data.getSummary())
                .icon(data.getIcon())
                .sunriseTime(Instant.ofEpochSecond(data.getSunriseTime()).atZone(ZoneId.of(forecastObj.getTimezone())).format(formatter))
                .sunsetTime(Instant.ofEpochSecond(data.getSunsetTime()).atZone(ZoneId.of(forecastObj.getTimezone())).format(formatter))
                .temperatureHigh(String.valueOf(data.getTemperatureHigh()))
                .temperatureLow(String.valueOf(data.getTemperatureLow()))
                .build();
    }

    public static ForecastDataDto convertForecastModelToForecastDto(String locationCode, String locationName, WeatherForecastModel forecastModel) {
        return ForecastDataDto.builder()
                .code(locationCode)
                .location(locationName)
                .summary(forecastModel.getSummary())
                .icon(forecastModel.getIcon())
                .sunriseTime(forecastModel.getSunriseTime())
                .sunsetTime(forecastModel.getSunsetTime())
                .temperatureHigh(String.valueOf(forecastModel.getTemperatureHigh()))
                .temperatureLow(String.valueOf(forecastModel.getTemperatureLow()))
                .build();
    }

}


