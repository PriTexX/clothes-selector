package com.example.clothesservice.controller;

import com.example.clothesservice.models.WeatherModel;
import com.example.clothesservice.service.interfaces.IClothesSelector;
import com.example.clothesservice.service.interfaces.IWeatherAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothesController {
    private final IWeatherAccess _weatherAccess;
    private final IClothesSelector _clothesSelector;

    @Autowired
    public ClothesController(IWeatherAccess weatherAccess, IClothesSelector clothesSelector){
        _weatherAccess = weatherAccess;
        _clothesSelector = clothesSelector;
    }

    @GetMapping
    public ResponseEntity<String> Get(String location){
        WeatherModel weatherModel;
        try {
            weatherModel = _weatherAccess.GetCurrentWeatherState();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        var clothesKit = _clothesSelector.PickClothes(weatherModel);

        var responseString = "Сегодня в городе Москва: %d C, ощущается как %d, %s - поэтому лучше надеть что либо из этого: %s; %s; %s"
                .formatted(
                        weatherModel.getTemperature(),
                        weatherModel.getFeelsLike(),
                        weatherModel.getWeather(),
                        Join(clothesKit.getUpperClothes(), ", "),
                        Join(clothesKit.getLowerClothes(), ", "),
                        Join(clothesKit.getShoes(), ", "));

        return ResponseEntity.ok(responseString);
    }

    private String Join(List<String> arr, String separator){
        var builder = new StringBuilder();

        for (int i=0; i<arr.size()-1; ++i){
            builder.append(arr.get(i));
            builder.append(separator);
        }

        builder.append(arr.get(arr.size()-1));
        return builder.toString();
    }
}
