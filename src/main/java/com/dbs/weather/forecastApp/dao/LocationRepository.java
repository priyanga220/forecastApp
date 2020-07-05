package com.dbs.weather.forecastApp.dao;

import com.dbs.weather.forecastApp.model.LocationModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends MongoRepository<LocationModel, String> {

    @Query(value = "{ 'forecasts.date': ?0 }")
    List<LocationModel> findByForecastsDate(LocalDate date);

    @Query(value = "{ 'code': ?0 }")
    Optional<LocationModel> findByCode(String code);
}
