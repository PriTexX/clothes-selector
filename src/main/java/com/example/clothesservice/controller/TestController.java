package com.example.clothesservice.controller;

import com.example.clothesservice.service.implementations.WeatherAccess;
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

    private IWeatherAccess _weatherAccess;

    public TestController(IWeatherAccess wa){
        _weatherAccess = wa;
    }

    @GetMapping("/test1")
    public ResponseEntity Get(){
        try {
            _weatherAccess.GetCurrentWeatherState();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/test2")
    public ResponseEntity Test(){

        return ResponseEntity.ok("Success with timeout");
    }
}
