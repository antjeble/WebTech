package htwberlin.webtech;

import htwberlin.webtech.web.api.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
}
