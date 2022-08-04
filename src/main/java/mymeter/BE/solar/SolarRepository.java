package mymeter.BE.solar;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarRepository extends MongoRepository<Solar, String> {
}
