package com.aperolabs.weather;

import com.aperolabs.weather.models.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@SpringBootApplication
public class WeatherFn {

    @Value("${weather.units}")
    private String units;

    @Component
    public class Forecast implements Function<String, String> {
        final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?zip={zip}&appid={appid}&units={units}";

        public String apply(String zip) {
            final String API_KEY = System.getenv("OPEN_WEATHER_API_KEY");
            RestTemplate restTemplate = new RestTemplate();
            Weather weather = restTemplate.getForObject(WEATHER_URL, Weather.class, zip, API_KEY, units);

            return weather.getMain().getTemp().toString();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherFn.class, args);
    }
}
