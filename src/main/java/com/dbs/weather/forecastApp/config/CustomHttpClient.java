package com.dbs.weather.forecastApp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
@ConfigurationProperties(prefix = "darksky")
@Getter
@Setter
public class CustomHttpClient {

    private String baseUrl;
    private char[] token;

    /*
    * Configures a Customized RestTemplate with darkSky API EndPoint + Credentials
     */
    @Bean(name = "darkskyHttpClient")
    public RestTemplate getDarkskyRestClient() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl.concat(String.valueOf(token))));
        return restTemplate;
    }


}
