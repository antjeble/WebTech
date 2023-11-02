package htwberlin.webtech;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
}
