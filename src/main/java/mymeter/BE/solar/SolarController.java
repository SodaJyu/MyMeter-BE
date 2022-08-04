package mymeter.BE.solar;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SolarController {

    final SolarService solarService;

    private final SolarRepository solarRepository;

    public SolarController(SolarService solarService, SolarRepository solarRepository) {
        this.solarService = solarService;
        this.solarRepository = solarRepository;
    }

    @PostMapping("/solar")
    public String saveSolar(@RequestBody Solar solar) {
        solarRepository.save(solar);
        return "Solar Panel Successfully Registered";
    }

    @GetMapping("/solar")
    public List<Solar> getSolar() {
        return solarService.getSolar();
    }

    @GetMapping("/solar/{id}")
    public Optional<Solar> getSolarById(@PathVariable String id) {
        return solarService.getSolarById(id);
    }

    @PutMapping("/solar/{id}")
    public Optional<Solar> modifySolar(Solar newSolar, @PathVariable String id) {
        return solarService.modifySolar(newSolar, id);
    }

    @DeleteMapping("/solar/{id}")
    public void deleteSolar(@PathVariable String id) {
        solarService.deleteSolar(id);
    }
}
