package mymeter.BE.weather;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class Weather {

    @Id
    public String id;
    public String city;
    public LocalDate date;
    public double maxGustSpeed;
    public double averageWindSpeed;
    public double uvIndex;

    public Weather(String city, LocalDate date, double averageWindSpeed, double maxGustSpeed, double uvIndex) {
        this.city = city;
        this.date = date;
        this.maxGustSpeed = maxGustSpeed;
        this.averageWindSpeed = averageWindSpeed;
        this.uvIndex = uvIndex;
    }
}
