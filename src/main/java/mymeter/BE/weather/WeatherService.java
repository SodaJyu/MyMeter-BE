package mymeter.BE.weather;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WeatherService {

    WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<Weather> getWeather() {
        return weatherRepository.findAll();
    }

    public Weather findWeatherByCity(String city) {
       return weatherRepository.findByCity(city);
    }

    public void deleteWeather(String id) {
        weatherRepository.deleteById(id);
    }

}
