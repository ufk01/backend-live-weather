package com.weather.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResponseDto {

    private Double temp;
    private Integer humidity;
    private Integer pressure;
    private String country;
    private String city;
    private Double windSpeed;
    private String description;
    private String icon;
    private Long dt;

}
