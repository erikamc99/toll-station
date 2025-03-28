package dev.erika.toll_station.vehicles.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckTest {
    private Truck truck;
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

    @BeforeEach
    public void setUp() {
        truck = new Truck("1234ABC", 5);
    }

    @Test
    @DisplayName("Test para comprobar que Truck se extiende y se establece correctamente")
    public void testTruckConstructor() {
        assertEquals("1234ABC", truck.getPlate());
    }

    @Test
    @DisplayName("Test para comprobar el cálculo del peaje respecto a los ejes del camión")
    public void testCalculateToll() {
        assertEquals(250, truck.calculateToll());
    }
}
