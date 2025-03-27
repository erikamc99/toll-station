package dev.erika.toll_station.tollstation.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.erika.toll_station.vehicles.model.Car;

public class TollStationTest {

    private TollStation tollStation;

    @BeforeEach
    void setUp() {
        tollStation = new TollStation("Autogrill", "Sagunto");
    }

    @Test
    @DisplayName("Test para comprobar que se crea la estación de peaje con un nombre")
    public void testTollStationConstructor() {
        assertEquals("Autogrill", tollStation.getName());
        assertEquals("Sagunto", tollStation.getCity());
    }

    @Test
    @DisplayName("Test para comprobar que se crea la lista de vehículos")
    public void testVehicleList() {
        assertEquals(0, tollStation.getVehicles().size());
    }

    @Test
    @DisplayName("Test para comprobar que se añade un coche a la lista")
    public void testAddVehicle() {
        Car car = new Car("1234ABC");
        tollStation.addVehicle(car);
        assertTrue(tollStation.getVehicles().contains(car));
    }

    @Test
    @DisplayName("Test para comprobar el cobro del peaje")
    public void testCollectToll() {
        Car car = new Car("1234ABC");
        tollStation.addVehicle(car);
        int toll = tollStation.collectToll(car);
        assertEquals(100, toll);
    }
}
