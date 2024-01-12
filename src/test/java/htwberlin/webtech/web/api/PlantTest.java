package htwberlin.webtech.web.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

    class PlantTest {

        @Test
        void testToString(){
            //Data
            String name = "Test";
            String duration = "3";
            boolean watered = false;

            //Creating a new Plant object
            Plant plant = new Plant(name, duration, watered);
            plant.setId(27L);

            //create expected an actual String
            String expected = "Plant{id=27, name='Test', duration='3'}";
            String actual = plant.toString();

            //Testing the toString method
            assertEquals(expected, actual);
        }

        @Test
        public void testEquals() {
            // Creating two Plant objects with the same properties
            Plant plant1 = new Plant("Rose", "10", true);
            Plant plant2 = new Plant("Rose", "10", true);

            // Testing the equals method
            assertTrue(plant1.equals(plant2));
        }

        @Test
        public void testNotEquals() {
            // Creating two Plant objects with different properties
            Plant plant1 = new Plant("Rose", "10", true);
            Plant plant2 = new Plant("Tulip", "5", false);

            // Testing the equals method
            assertTrue(!plant1.equals(plant2));
        }
    }