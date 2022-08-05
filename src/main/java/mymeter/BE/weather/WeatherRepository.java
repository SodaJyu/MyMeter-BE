package mymeter.BE.weather;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WeatherRepository extends MongoRepository<Weather, String> {
    Weather findByCity(String city);
    Weather findByDate(Date date);
}
