package dk.via.sep4.controllers;

import dk.via.sep4.models.Temperature;
import dk.via.sep4.exceptions.TemperatureNotFoundException;
import dk.via.sep4.repo.TemperatureRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TemperatureController {
    private final TemperatureRepository repo;

    public TemperatureController(TemperatureRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/temperatures")
    List<Temperature> all() {
        return repo.findAll();
    }

    @PostMapping("/temperature")
    Temperature newValue(@RequestBody Temperature newTemperature) {
        return repo.save(newTemperature);
    }

    @PostMapping("/temperature/{norm}")
    Temperature addNorm(@RequestBody Temperature newTemperature, double norm) {
        newTemperature.setNorm(norm);
        return repo.save(newTemperature);
    }

    @GetMapping("/temperature/{id}")
    Temperature one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(()
                -> new TemperatureNotFoundException(id));
    }

//    @PutMapping("/temperature/{id}")
//    Temperature update(@RequestBody Temperature newTemperature, @PathVariable Long id) {
//        return repo.findById(id)
//                .map(temperature -> {
//                    temperature.setValue(newTemperature.getValue());
//                    return repo.save(temperature);
//                })
//                .orElseGet(() -> {
//                    newTemperature.setId(id);
//                    return repo.save(newTemperature);
//                });
//    }

    @DeleteMapping("temperature/{id}")
    void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
