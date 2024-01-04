package htwberlin.webtech.web.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

    class PlantTest {
        @Test
        void testToString(){
            //Eingabe
            String name = "Test";
            String duration = "3";

            //Ausführung
            Plant plant = new Plant(name, duration);
            plant.setId(27L);

            //Erwartung
            String expected = "Plant{id=27, name='Test', duration='3'}";

            //Tatsächliche Ausgabe
            String actual = plant.toString();

            //Vergleich
            assertEquals(expected, actual);
        }
    }
