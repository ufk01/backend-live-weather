package com.weather.service.Impl;

import com.weather.config.WeatherProperties;
import com.weather.mapper.WeatherPropertiesMapper;
import com.weather.model.WeatherPropertiesDto;
import com.weather.model.WeatherResponseDto;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


@Service
public class WeatherServiceImpl implements WeatherService {

    private static final WeatherPropertiesMapper weatherConfigMapper = WeatherPropertiesMapper.MAPPER;
    private final RestTemplate restTemplate;

    @Value("${weather.location.country}")
    private String country;
    @Value("${weather.location.city}")
    private String city;
    @Value("${weather.key}")
    private String key;

    public WeatherServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public WeatherResponseDto getInputInformations(WeatherPropertiesDto weatherPropertiesDto) {
        String queryCountry = country;
        String queryCity = city;
        if(weatherPropertiesDto != null && Objects.nonNull(weatherPropertiesDto.getCity()) && Objects.nonNull(weatherPropertiesDto.getCountry())) {
            WeatherProperties weatherProperties = weatherConfigMapper.weatherPropertiesDtoToWeatherProperties(weatherPropertiesDto);
            queryCountry = weatherProperties.getCountry();
            queryCity = weatherProperties.getCity();
        }
        return getLiveWeather(queryCountry, queryCity);
    }

    public WeatherResponseDto getLiveWeather(String country, String city) {
        try {
            String url = buildWeatherApiUrl(country, city);
            return restTemplate.getForObject(url, WeatherResponseDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch live weather data", e);
        }
    }

    private String buildWeatherApiUrl(String country, String city) {
        return String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s,%s&appid=%s",
                city.toLowerCase(),
                country.toLowerCase(),
                key
        );
    }
}
