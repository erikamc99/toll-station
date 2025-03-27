package dev.erika.toll_station.tollstation.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TollStationTest {
    @Test
    @DisplayName("Test para comprobar que se crea la estación de peaje con un nombre")
    public void testTollStationConstructor() {
        TollStation tollStation = new TollStation("Autogrill");
        assertEquals("Autogrill", tollStation.getName());
    }
}
