package com.weather.config;

import com.weather.enums.TimeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherProperties {

    private Long id;
    private String city;
    private String country;


}
