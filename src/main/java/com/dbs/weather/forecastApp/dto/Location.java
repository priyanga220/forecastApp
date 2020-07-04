package com.dbs.weather.forecastApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    private String name;
    private String latitude;
    private String longitude;

    public String getLocationMatrix() {
        return this.latitude.concat(",").concat(this.longitude);
    }
}
