package com.dbs.weather.forecastApp.dao.impl;

import com.dbs.weather.forecastApp.dao.CustomLocationRepository;
import com.dbs.weather.forecastApp.model.LocationModel;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class CustomLocationRepositoryImpl implements CustomLocationRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    /*
    * Removes foreCast Information of all Location Documents for the given date
     */
    @Override
    public void removeForecastByDate(LocalDate date) {
        mongoTemplate.updateMulti(new Query(), new Update().pull("forecasts",  new BasicDBObject("forecasts.date", date )), LocationModel.class);
    }
}
