package mymeter.BE.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import java.util.List;

@RestController
public class WeatherController {

    final WeatherService weatherService;
    private final WeatherRepository weatherRepository;

    @Value("${weather.api-key}")
    public String API_KEY = System.getenv("weather.api-key");

    public WeatherController(WeatherService weatherService, WeatherRepository weatherRepository) {
        this.weatherService = weatherService;
        this.weatherRepository = weatherRepository;
    }

    @PostMapping("/weather")
    public void saveWeather(@RequestBody Weather weather) {
        if (weatherRepository.findByDateAndCity(weather.getDate(), weather.getCity()) == null){
            weatherRepository.save(weather);
        }
    }

    @GetMapping("/weather")
    public List<Weather> getWeather() {
        return weatherService.getWeather();
    }

    @GetMapping("/weather/{city}")
    public List<Weather> getWeatherByCity(@PathVariable String city) {
        return weatherService.findWeatherByCity(city);
    }

    @GetMapping("/weatherAPI/")
    public Object getWeatherFromAPI() {
        String url = "http://api.weatherapi.com/v1/forecast.json?key="+ API_KEY +"&q=London&days=1&aqi=no&alerts=no";
        RestTemplate restTemplate = new RestTemplate();

        Object weatherData = restTemplate.getForObject(url, String.class);
        return weatherData;
    }

    @DeleteMapping("/weather/{id}")
    public void deleteWeather(@PathVariable String id) {
        weatherService.deleteWeather(id);
    }
}
