package htwberlin.webtech.web;

import htwberlin.webtech.Plant;
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

    @PostMapping("/plants")
    public Plant createPlant(@RequestBody Plant plant) {
        return service.save(plant);
    }
    @GetMapping("/plants/{id}")
    public Plant getPlant(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long plantId = Long.parseLong(id);
        return service.get(plantId);
    }
    @GetMapping("/plants")
    public List<Plant> getAllPlants() {
        return service.getAll();
    }
}