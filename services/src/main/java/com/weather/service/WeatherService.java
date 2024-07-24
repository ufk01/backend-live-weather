package com.weather.service;

import com.weather.model.WeatherResponseDto;

public interface WeatherService {

    WeatherResponseDto getInputInformations(String country, String city);
}
