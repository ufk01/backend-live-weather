package com.weather.mapper;

import com.weather.config.WeatherProperties;
import com.weather.model.WeatherPropertiesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherPropertiesMapper {
    WeatherPropertiesMapper MAPPER = Mappers.getMapper(WeatherPropertiesMapper.class);
    WeatherPropertiesDto weatherPropertiesToWeatherPropertiesDto(WeatherProperties weatherConfig);
    WeatherProperties weatherPropertiesDtoToWeatherProperties(WeatherPropertiesDto weatherConfigDto);

}
