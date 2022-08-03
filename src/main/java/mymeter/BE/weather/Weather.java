package mymeter.BE.weather;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Weather {

    public String city;
    public Date date;
    public String cloudCover;
    public int windSpeed;
    public String windDirection;

    public Weather(String city, Date date, String cloudCover, int windSpeed, String windDirection) {
        this.city = city;
        this.date = date;
        this.cloudCover = cloudCover;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }
}
