package com.dbs.weather.forecastApp.controller;

import com.dbs.weather.forecastApp.service.ForecastService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForecastController {

    private static final Logger logger = LoggerFactory.getLogger(ForecastController.class);

    @Autowired
    private ForecastService forecastService;

    @GetMapping("/")
    public String forecastPage(Model model) {

        logger.info("Request was made for fetching Forecast Data");
        model.addAttribute("forecastList", forecastService.retrieveLatestForecast());
        return "forecast";
    }
}
