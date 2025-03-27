package dev.erika.toll_station.vehicles.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MotorbikeTest {
    public class TestMotorbike extends Vehicle {
        public TestMotorbike(String plate) {
            super(plate);
        }

        @Override
        public int calculateToll() {
            return 50;
        }
    }

    @Test
    @DisplayName("Test para comprobar que Motorbike se extiende y se establece correctamente")
    public void testMotorbikeConstructor() {
        Motorbike motorbike = new Motorbike("1234ABC");
        assertEquals("1234ABC", motorbike.getPlate());
    }
}
