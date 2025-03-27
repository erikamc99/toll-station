package dev.erika.toll_station.vehicles.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    public class TestCar extends Vehicle {
        public TestCar(String plate) {
            super(plate);
        }

        @Override
        public int calculateToll() {
            return 50;
        }
    }

    @Test
    @DisplayName("Test para comprobar que Car se extiende y se establece correctamente")
    public void testCarConstructor() {
        Car car = new Car("1234ABC");
        assertEquals("1234ABC", car.getPlate());
        assertEquals(50, car.calculateToll());
    }
}
