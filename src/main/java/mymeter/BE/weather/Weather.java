package mymeter.BE.weather;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Weather {

    @Id
    public String id;
    public String city;
    public Date date;
    public String cloudCover;
    public int windSpeed;
    public int maxGustSpeed;
    public int averageWindSpeed;
    public String windDirection;

    public int uvIndex;

    public Weather(String city, Date date, String cloudCover, int windSpeed, int maxGustSpeed, String windDirection, int uvIndex) {
        this.city = city;
        this.date = date;
        this.cloudCover = cloudCover;
        this.windSpeed = windSpeed;
        this.maxGustSpeed = maxGustSpeed;
        this.averageWindSpeed = windSpeed + maxGustSpeed / 2;
        this.windDirection = windDirection;
        this.uvIndex = uvIndex;
    }
}
