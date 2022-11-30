package com.example.clothesservice.controller;

import com.example.clothesservice.models.WeatherModel;
import com.example.clothesservice.service.implementations.WeatherAccess;
import com.example.clothesservice.service.interfaces.IClothesSelector;
import com.example.clothesservice.service.interfaces.IWeatherAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/test")
public class TestController {

    private final IWeatherAccess _weatherAccess;
    private final IClothesSelector _clothesSelector;

    @Autowired
    public TestController(IWeatherAccess wa, IClothesSelector cs){
        _weatherAccess = wa;_clothesSelector = cs;
    }

    @GetMapping("/test1")
    public ResponseEntity Get(){
        WeatherModel weatherModel;
        try {
            weatherModel = _weatherAccess.GetCurrentWeatherState();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        weatherModel.setWeather("Rain");
        weatherModel.setWindSpeed(9);
        weatherModel.setFeelsLike(-20);
        var f = _clothesSelector.PickClothes(weatherModel);
        return ResponseEntity.ok(weatherModel);
    }

    @GetMapping("/test2")
    public ResponseEntity Test(){

        return ResponseEntity.ok("Success with timeout");
    }
}
