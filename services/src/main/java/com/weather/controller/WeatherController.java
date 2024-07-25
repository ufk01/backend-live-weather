package com.weather.controller;

import com.weather.model.WeatherApiResponseDto;
import com.weather.model.WeatherResponseDto;
import com.weather.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/information")
    public @ResponseBody ResponseEntity<WeatherResponseDto> getLiveWeatherInformation(@RequestParam(value = "country", required = false) String country,
                                                                                      @RequestParam(value = "city", required = false) String city){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(weatherService.getInputInformations(country, city));
    }
}
