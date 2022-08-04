package mymeter.BE.wind;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WindController {

    final WindService windService;

    private final WindRepository windRepository;

    public WindController(WindService windService, WindRepository windRepository) {
        this.windService = windService;
        this.windRepository = windRepository;
    }

    @PostMapping("/wind")
    public String addWind(Wind wind) {
        windRepository.save(wind);
        return "Wind Turbine Successfully Added";
    }

    @GetMapping("/wind")
    public List<Wind> getWind() {
        return windService.getWind();
    }

    @GetMapping("/users/{id}")
    public Optional<Wind> getWindById(@PathVariable String id) {
        return windService.getWindById(id);
    }

    @PutMapping("/wind/{id}")
    public Optional<Wind> modifyWind(Wind newWind, @PathVariable String id) {
        return windService.modifyWind(newWind, id);
    }

    @DeleteMapping("/wind/{id}")
    public void deleteWind(@PathVariable String id) {
        windService.deleteWind(id);
    }
}
