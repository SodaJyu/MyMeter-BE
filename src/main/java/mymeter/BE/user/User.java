package mymeter.BE.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    private String id;
    private String first_name;
    private String last_name;
   @Indexed(unique = true)
    private String email;
    private String city;

    public User(String first_name, String last_name, String email, String city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.city = city;
    }

}
