package com.aperolabs.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@SpringBootApplication
public class WeatherFn {

    @Component
    public class Forecast implements Function<String, String> {
        final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?zip={zip}&appid={appid}";

        public String apply(String zip) {
            final String API_KEY = System.getenv("OPEN_WEATHER_API_KEY");
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response =
                    restTemplate.getForEntity(WEATHER_URL, String.class, zip, API_KEY);

            return response.toString();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherFn.class, args);
    }
}
