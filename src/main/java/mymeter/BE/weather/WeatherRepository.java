package mymeter.BE.weather;

import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherRepository extends MongoRepository<Weather, String> {
    List<Weather> findByCity(String city);
    Weather findByDateAndCity(LocalDate date, String city);
}
