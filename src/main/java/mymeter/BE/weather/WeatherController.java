package mymeter.BE.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    final WeatherService weatherService;
    private final WeatherRepository weatherRepository;

    public WeatherController(WeatherService weatherService, WeatherRepository weatherRepository) {
        this.weatherService = weatherService;
        this.weatherRepository = weatherRepository;
    }

    @PostMapping("/weather")
    public void saveWeather(Weather weather) {
        weatherRepository.save(weather);
    }

    @GetMapping("/weather")
    public List<Weather> getWeather() {
        return weatherService.getWeather();
    }

    @GetMapping("/weather/{city}")
    public Weather getWeatherByCity(@PathVariable String city) {
        return weatherService.findWeatherByCity(city);
    }
}
