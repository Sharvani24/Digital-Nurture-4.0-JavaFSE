package com.example;

public class WeatherService {
    private WeatherApi api;

    public WeatherService(WeatherApi api) {
        this.api = api;
    }

    public String fetchWeatherReport() {
        return api.getWeather();
    }
}
