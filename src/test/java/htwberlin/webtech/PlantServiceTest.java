package htwberlin.webtech;


import htwberlin.webtech.web.api.Plant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class PlantServiceTest {

    @Autowired
    private PlantService service;

    @MockBean
    private PlantRepository repository;

    @Test
    @DisplayName("should find a plant by id")
    void testGet(){
        var p1 = new Plant("Test", "3", true);
        var p2 = new Plant("Test2", "4", false);
        doReturn(Optional.of(p1)).when(repository).findById(27L);
        doReturn(Optional.of(p2)).when(repository).findById(28L);

        Plant actual = service.get(27L);

        assertEquals(actual.getDuration(), "3");
    }

    @Test
    @DisplayName("should save a plant")
    void testSave(){
        var p1 = new Plant("Test", "3", true);
        doReturn(p1).when(repository).save(p1);

        Plant actual = service.save(p1);

        assertEquals(actual.getDuration(), "3");
    }

    @Test
    @DisplayName("should delete a plant")
    void testDelete(){
        var p1 = new Plant("Test", "3", true);
        doReturn(Optional.of(p1)).when(repository).findById(27L);

        service.delete(27L);

        assertEquals(service.getAll().size(), 0);
    }
}
