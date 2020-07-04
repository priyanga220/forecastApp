package com.dbs.weather.forecastApp.config;

import com.dbs.weather.forecastApp.dto.Location;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "")
@Getter
@Setter
public class LocationConfiguration {

    private Map<String, Location> locations = new HashMap<>();

    public Location getLocationByCode(String code) {
        return locations.get(code);
    }
}
