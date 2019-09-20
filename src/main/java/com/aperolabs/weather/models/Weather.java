package com.aperolabs.weather.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Weather {
    private Main main;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public class Main {
        private Float temp;
        private Float pressure;
        private Float humidity;
    }
}
