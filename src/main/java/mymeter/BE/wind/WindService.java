package mymeter.BE.wind;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WindService {

    final WindRepository windRepository;

    public WindService(WindRepository windRepository) {
        this.windRepository = windRepository;
    }

    public List<Wind> getWind() {
        return windRepository.findAll();
    }

    public Optional<Wind> getWindById(String id) {
        return windRepository.findById(id);
    }

    public Optional<Wind> modifyWind(Wind newWind, String id) {
        return windRepository.findById(id)
                .map(wind -> {
                    wind.type = newWind.getType();
                    wind.powerRating = newWind.getPowerRating();
                    wind.sweptArea = newWind.getSweptArea();
                    wind.height = newWind.getHeight();
                    return windRepository.save(wind);
                });
    }

    public void deleteWind(String id) {
        windRepository.deleteById(id);
    }
}
