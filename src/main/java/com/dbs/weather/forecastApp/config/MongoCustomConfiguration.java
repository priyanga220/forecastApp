package com.dbs.weather.forecastApp.config;

import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class MongoCustomConfiguration {

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //Custom Conversions for Local Date <-> String[yyyy-MM-dd]
        return new MongoCustomConversions(Arrays.asList(new Converter[]{

                new Converter<LocalDate, String>() {
                    @Override
                    public String convert(@NonNull LocalDate source) {
                        return source.format(dateTimeFormatter);
                    }
                },

                new Converter<String, LocalDate>() {
                    @Override
                    public LocalDate convert(@NonNull String source) {
                        return LocalDate.parse(source, dateTimeFormatter);
                    }
                }

        }));
    }
}
