package com.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.entity.Main;
import com.weather.entity.Sys;
import com.weather.entity.Weather;
import com.weather.entity.Wind;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponseDto {

    @JsonProperty("weather")
    private List<Weather> weatherList;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("sys")
    private Sys sys;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("timezone")
    private Long timezone;

    @JsonProperty("name")
    private String name;

    @JsonProperty("dt")
    private Long dt;

}
