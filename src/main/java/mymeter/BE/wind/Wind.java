package mymeter.BE.wind;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Wind {
    @Id
    public String id;
    public String type;
    public int powerRating;
    public int sweptArea;
    public int height;

    public Wind(String type, int powerRating, int sweptArea, int height) {
        this.type = type;
        this.powerRating = powerRating;
        this.sweptArea = sweptArea;
        this.height = height;
    }
}
