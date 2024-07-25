package com.weather.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Prop {
    private Double temp;
    private Integer pressure;
    private Integer humidity;
}
