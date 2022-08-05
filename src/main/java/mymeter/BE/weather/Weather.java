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
    public int maxWindSpeed;
    public int averageWindSpeed;
    public String windDirection;

    public int uvIndex;

    public Weather(String city, Date date, String cloudCover, int maxWindSpeed, int averageWindSpeed, String windDirection, int uvIndex) {
        this.city = city;
        this.date = date;
        this.cloudCover = cloudCover;
        this.maxWindSpeed = maxWindSpeed;
        this.averageWindSpeed = averageWindSpeed;
        this.windDirection = windDirection;
        this.uvIndex = uvIndex;
    }
}
