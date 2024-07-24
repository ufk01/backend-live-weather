package com.weather.service.Impl;

import com.weather.model.WeatherResponseDto;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class WeatherServiceImpl implements WeatherService {

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
    public WeatherResponseDto getInputInformations(String countryParam, String cityParam) {
        return countryParam != null && cityParam != null ? getLiveWeather(countryParam, cityParam) : getLiveWeather(country, city);
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
