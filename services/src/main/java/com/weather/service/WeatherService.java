package com.weather.service;

import com.weather.model.WeatherPropertiesDto;
import com.weather.model.WeatherResponseDto;

public interface WeatherService {

    WeatherResponseDto getInputInformations(WeatherPropertiesDto weatherPropertiesDto);
}
