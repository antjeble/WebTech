package htwberlin.webtech.web;

import htwberlin.webtech.web.api.Plant;
import htwberlin.webtech.PlantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PlantController {

    @Autowired
    PlantService service;

    Logger logger = LoggerFactory.getLogger(PlantController.class);

    @CrossOrigin
    @PostMapping("/plants")
    public Plant createPlant(@RequestBody Plant plant) {
        if (plant == null || plant.getName() == null || plant.getDuration() == null) {
            throw new IllegalArgumentException("Plant must have a name and a duration");
        }
        return service.save(plant);
    }

    @CrossOrigin
    @GetMapping("/plants/{id}")
    public Plant getPlant(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long plantId = Long.parseLong(id);
        return service.get(plantId);
    }

    @CrossOrigin
    @GetMapping("/plants")
    public List<Plant> getAllPlants() {
        return service.getAll();
    }

    @CrossOrigin
    @DeleteMapping("/plants/{id}")
    public void deletePlant(@PathVariable Long id){
        service.delete(id);
    }

    @CrossOrigin
    @PutMapping("/plants/{id}")
    public Plant updatePlant(@PathVariable Long id, @RequestBody Plant plant){
        return service.update(id, plant);
    }
}
