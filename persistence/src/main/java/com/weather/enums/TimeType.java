package com.weather.enums;

public enum TimeType {

    HOURS("SAAT"),
    MINUTES("DAKİKA"),
    SECONDS("SANİYE");

    private final String timeType;

    TimeType(String timeType){
        this.timeType = timeType;
    }
    public String getTimeType(){
        return timeType;
    }
}
