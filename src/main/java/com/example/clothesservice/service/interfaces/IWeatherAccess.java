package com.example.clothesservice.service.interfaces;

import com.example.clothesservice.models.WeatherModel;

import java.net.URISyntaxException;

public interface IWeatherAccess {
    WeatherModel GetCurrentWeatherState() throws URISyntaxException;
}
