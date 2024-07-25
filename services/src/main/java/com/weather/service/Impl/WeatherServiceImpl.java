package com.weather.service.Impl;

import com.weather.model.WeatherApiResponseDto;
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
        final WeatherApiResponseDto weatherApiResponseDto =  countryParam != null && cityParam != null ? getLiveWeather(countryParam, cityParam) :
                countryParam == null && cityParam != null ? getLiveWeather(country, cityParam) : getLiveWeather(country, city);
        return WeatherResponseDto.builder()
                .temp(weatherApiResponseDto.getProp().getTemp())
                .humidity(weatherApiResponseDto.getProp().getHumidity())
                .pressure(weatherApiResponseDto.getProp().getPressure())
                .country(weatherApiResponseDto.getSys().getCountry())
                .city(weatherApiResponseDto.getName())
                .windSpeed(weatherApiResponseDto.getWind().getSpeed())
                .description(weatherApiResponseDto.getWeatherList().get(0).getDescription())
                .icon(weatherApiResponseDto.getWeatherList().get(0).getIcon())
                .dt(weatherApiResponseDto.getDt())
                .build();
    }

    public WeatherApiResponseDto getLiveWeather(String country, String city) {
        try {
            String url = buildWeatherApiUrl(country, city);
            return restTemplate.getForObject(url, WeatherApiResponseDto.class);
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
