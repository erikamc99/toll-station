package dev.erika.toll_station.vehicles.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {
    
    public static class TestVehicle extends Vehicle {

        public TestVehicle(String plate) {
            super(plate);
        }

        @Override
        public int calculateToll() {
            return 0;
        }
    }

        @Test
        @DisplayName("Test para comprobar que se establece y obtiene la matrícula")
        public void testVehicleConstructor() {
            
            Vehicle vehicle = new TestVehicle("1234ABC");
            assertEquals("1234ABC", vehicle.getPlate());
        }    
}