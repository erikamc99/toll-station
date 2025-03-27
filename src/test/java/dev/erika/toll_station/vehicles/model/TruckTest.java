package dev.erika.toll_station.vehicles.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckTest {

    private int axles;

    public class TestTruck extends Vehicle {
        public TestTruck(String plate, int axles) {
            super(plate);
        }


        @Override
        public int calculateToll() {
            return 50*axles;
        }
    }

    @Test
    @DisplayName("Test para comprobar que Truck se extiende y se establece correctamente")
    public void testTruckConstructor() {
        Truck truck = new Truck("1234ABC", 2);
        assertEquals("1234ABC", truck.getPlate());
    }
}
