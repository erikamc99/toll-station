package dev.erika.toll_station.tollstation.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.erika.toll_station.vehicles.model.Car;
import dev.erika.toll_station.vehicles.model.Motorbike;

public class TollStationTest {
    @Test
    @DisplayName("Test para comprobar que se crea la estación de peaje con un nombre")
    public void testTollStationConstructor() {
        TollStation tollStation = new TollStation("Autogrill", "Sagunto");
        assertEquals("Autogrill", tollStation.getName());
        assertEquals("Sagunto", tollStation.getCity());
    }

    @Test
    @DisplayName("Test para comprobar que se crea la lista de vehículos")
    public void testVehicleList() {
        TollStation tollStation = new TollStation("Autogrill", "Sagunto");
        assertEquals(0, tollStation.getVehicles().size());
    }

    @Test
    @DisplayName("Test para comprobar que se añade un coche a la lista")
    public void testAddVehicle() {
        TollStation tollStation = new TollStation("Autogrill", "Sagunto");
        Car car = new Car("1234ABC");
        tollStation.addVehicle(car);
        assertTrue(tollStation.getVehicles().contains(car));
    }
}
