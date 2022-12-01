package com.example.clothesservice.service.interfaces;

import com.example.clothesservice.models.ClothesKit;
import com.example.clothesservice.models.WeatherModel;

public interface IClothesSelector {
    ClothesKit PickClothes(WeatherModel weatherModel);
}
