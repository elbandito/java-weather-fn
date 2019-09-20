package com.aperolabs.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@SpringBootApplication
public class WeatherFn {

    @Component
    public class Forecast implements Function<String, String> {
        public String apply(String name) {
            RestTemplate restTemplate = new RestTemplate();
            String weatherUrl = "https://samples.openweathermap.org/data/2.5/weather{zip}{appid}";
            ResponseEntity<String> response =
                    restTemplate.getForEntity(weatherUrl, String.class, "80516", "b6907d289e10d714a6e88b30761fae22");

            return response.toString();
        }
    }
//    @Bean
//    public Function<String, String> uppercase() {
//        RestTemplate restTemplate = new RestTemplate();
//        String weatherUrl = "https://samples.openweathermap.org/data/2.5/weather{zip}{appid}";
//        ResponseEntity<String> response =
//                restTemplate.getForEntity(weatherUrl, String.class, "80516", "b6907d289e10d714a6e88b30761fae22");
//
//        return s -> s.toUpperCase();
//    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherFn.class, args);
    }
}
