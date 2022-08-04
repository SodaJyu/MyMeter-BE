package mymeter.BE.solar;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Solar {

    @Id
    public String id;
    public String directionFacing;
    public String kWh;

    public Solar(String directionFacing, String kWh) {
        this.directionFacing = directionFacing;
        this.kWh = kWh;
    }

    public String getDirectionFacing() {
        return directionFacing;
    }

    public String getkWh() {
        return kWh;
    }

}
