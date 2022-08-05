package mymeter.BE.weather;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends MongoRepository<Weather, String> {
    List<Weather> findByCity(String city);
    Weather findByDateAndCity(Date date, String city);
}
