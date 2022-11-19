package com.example.clothesservice.models;

public class WeatherModel {
    private int temperature;
    private int humidity; // влажность
    private int windSpeed;
    private String weather;
    private int feelsLike;
    private Boolean isDay;

    public WeatherModel(int temperature, int humidity, int windSpeed, String weather, int feelsLike, Boolean isDay) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.weather = weather;
        this.feelsLike = feelsLike;
        this.isDay = isDay;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(int feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Boolean isDay() {
        return isDay;
    }

    public void setDay(Boolean day) {
        isDay = day;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", weather='" + weather + '\'' +
                ", feelsLike=" + feelsLike +
                ", isDay=" + isDay +
                '}';
    }
}
