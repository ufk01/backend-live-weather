package com.weather.model;

import lombok.Data;

@Data
public class WeatherPropertiesDto {

    private Long id;
    private String city;
    private String country;
}
