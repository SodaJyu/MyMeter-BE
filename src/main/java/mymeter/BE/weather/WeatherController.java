package mymeter.BE.weather;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@RestController
public class WeatherController {

    final WeatherService weatherService;
    private final WeatherRepository weatherRepository;
    @Value("${weather.api-key}")
    private String API_KEY = System.getenv("weather.api-key");

    public static<T> T getNestedValue(Map map, String... keys) {
        Object value = map;

        for(String key: keys) {
            value = ((Map) value).get(key);
        }
        return (T) value;
    }

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
        if (weatherRepository.findByDateAndCity(LocalDate.now(), city) == null) {
            //Object currentWeather = getWeatherFromAPI(city);

        }
        return weatherService.findWeatherByCity(city);
    }

    @GetMapping("/weatherAPI/{city}")
    public void getWeatherFromAPI(@PathVariable String city) {
        String url = "http://api.weatherapi.com/v1/forecast.json?key="+ API_KEY +"&q="+ city;
        RestTemplate restTemplate = new RestTemplate();
        String weatherData = restTemplate.getForObject(url, String.class);
        JsonParser weatherParser = JsonParserFactory.getJsonParser();
        Map<String, Object> weatherMap = weatherParser.parseMap(weatherData);
        Map<String, Object> list = getNestedValue(weatherMap, "forecast");
        ArrayList forecastDay = getNestedValue(list, "forecastday");
        LinkedHashMap forecastData = (LinkedHashMap)forecastDay.get(0);
        ArrayList<Object> hourlyData = (ArrayList) forecastData.get("hour");
        double averageWind = 0;
        double averageUV = 0;
        double maxGust = 0;
        LocalDate date = LocalDate.parse((String)forecastData.get("date"));

        for (int i = 0; i < hourlyData.size(); i++) {
            LinkedHashMap hour = (LinkedHashMap) hourlyData.get(i);
            double wind = (double) hour.get("wind_mph");
            double UV = (double) hour.get("uv");
            double hourMaxGust = (double) hour.get("gust_mph");
            if (hourMaxGust > maxGust) maxGust = hourMaxGust;
            averageUV = averageUV + UV;
            averageWind = averageWind + wind;
        }
        Weather daysWeather = new Weather(city, date, (averageWind / hourlyData.size()), maxGust, (averageUV / hourlyData.size()));
        System.out.println(daysWeather);
    }

    @DeleteMapping("/weather/{id}")
    public void deleteWeather(@PathVariable String id) {
        weatherService.deleteWeather(id);
    }
}
