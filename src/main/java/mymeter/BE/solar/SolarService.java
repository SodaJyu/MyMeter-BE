package mymeter.BE.solar;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolarService {

    SolarRepository solarRepository;

    public SolarService(SolarRepository solarRepository) {
        this.solarRepository = solarRepository;
    }

    public List<Solar> getSolar() {
        return solarRepository.findAll();
    }

    public Optional<Solar> getSolarById(String id) {
        return solarRepository.findById(id);
    }

    public Optional<Solar> modifySolar(Solar newSolar, String id)  {
        return solarRepository.findById(id)
                .map(solar -> {
                    solar.directionFacing = newSolar.getDirectionFacing();
                    solar.kWh = newSolar.getKWh();
                    return solarRepository.save(solar);
                });
    }

    public void deleteSolar(String id) {
        solarRepository.deleteById(id);
    }
}
