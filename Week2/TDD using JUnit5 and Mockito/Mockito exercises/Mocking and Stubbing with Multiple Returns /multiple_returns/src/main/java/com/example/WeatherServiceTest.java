package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {

    @Test
    public void testWeatherApiMultipleReturns() {
        WeatherApi mockApi = mock(WeatherApi.class);

        when(mockApi.getWeather())
            .thenReturn("Sunny")
            .thenReturn("Rainy")
            .thenReturn("Cloudy");

        WeatherService service = new WeatherService(mockApi);

        assertEquals("Sunny", service.fetchWeatherReport());
        assertEquals("Rainy", service.fetchWeatherReport());
        assertEquals("Cloudy", service.fetchWeatherReport());
    }
}
