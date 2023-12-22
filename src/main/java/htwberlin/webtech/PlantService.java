package htwberlin.webtech;

import htwberlin.webtech.web.api.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    PlantRepository repo;
    public Plant save(Plant plant) {
        plant = new Plant(plant.getName(), plant.getDuration());
        return repo.save(plant);
    }

    public Plant get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Plant> getAll() {
        Iterable<Plant> iterator = repo.findAll();
        List<Plant> things = new ArrayList<Plant>();
        for (Plant thing : iterator)  things.add(thing);
        return things;
    }
}
