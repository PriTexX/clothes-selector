package com.example.clothesservice.service.implementations;

import com.example.clothesservice.models.WeatherModel;
import com.example.clothesservice.service.interfaces.IWeatherAccess;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherAccess implements IWeatherAccess {
    private final HttpClient _client;

    public WeatherAccess(){
        _client = HttpClient.newHttpClient();
    }

    @Override
    public WeatherModel GetCurrentWeatherState() throws URISyntaxException {

//        var request = HttpRequest.newBuilder()
//                .uri(new URI("https://aerisweather1.p.rapidapi.com/observations/moscow,ru"))
//                .GET()
//                .header("X-RapidAPI-Key", "48a90c9cc6mshdfd4feaf8f87050p1a3e9djsnc3e852683ec0")
//                .header("X-RapidAPI-Host", "aerisweather1.p.rapidapi.com")
//                .build();

        var request = HttpRequest.newBuilder()
                .uri(new URI("https://aerisweather1.p.rapidapi.com/observations/moscow,ru"))
                .GET()
                .header("X-RapidAPI-Key", "48a90c9cc6mshdfd4feaf8f87050p1a3e9djsnc3e852683ec0")
                .header("X-RapidAPI-Host", "aerisweather1.p.rapidapi.com")
                .build();

        HttpResponse<String> response;
        try {
            response = _client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String responseString = response.body();

        JsonElement stringElement = JsonParser.parseString(responseString);
        JsonObject stringObject = stringElement.getAsJsonObject();

        int temperature = (int)stringObject.get("tempC").getAsLong();
        int humidity = (int)stringObject.get("humidity").getAsLong();
        int windSpeed = (int)stringObject.get("windKPH").getAsLong();
        String weather = stringObject.get("weatherShort").getAsString();
        int feelsLike = (int)stringObject.get("feellikeC").getAsLong();
        boolean isDay = stringObject.get("isDay").getAsBoolean();

        WeatherModel currentWeather = new WeatherModel(temperature,
                humidity, windSpeed,weather,feelsLike,isDay);

        System.out.println(currentWeather.toString());
        System.out.println("Pause");
        return null;
    }
}
