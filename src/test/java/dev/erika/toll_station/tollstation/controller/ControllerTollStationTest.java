package dev.erika.toll_station.tollstation.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dev.erika.toll_station.tollstation.model.TollStation;
import dev.erika.toll_station.vehicles.model.Car;

public class ControllerTollStationTest {
    @Mock
    private TollStation tollStation;
    
    private TollStationController controller;
    
    private Car car;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new TollStationController(tollStation); 
        car = new Car("1234ABC");
    }
    
    @Test
    @DisplayName("Test que comprueba el cobro de peaje a un vehículo")
    void testCollectToll() {

        when(tollStation.collectToll(car)).thenReturn(100);
        
        ResponseEntity<?> response = controller.collectToll(car);
        
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    @DisplayName("Test que comprueba el reporte del peaje")
    public void testPrintReport() {

        when(tollStation.getName()).thenReturn("Autogrill");
        when(tollStation.getCity()).thenReturn("Sagunto");
        when(tollStation.getVehicles()).thenReturn(Arrays.asList(car));
        when(tollStation.collectToll(car)).thenReturn(100);

        ResponseEntity<String> response = controller.printReport();

        String report = response.getBody();
        assertThat(report, containsString("=== Reporte de: Autogrill, Sagunto ==="));
        assertThat(report, containsString("Vehículos atendidos:"));
        assertThat(report, containsString("Matrícula: 1234ABC, Peaje: 100$"));
        assertThat(report, containsString("Total recolectado: 100$"));
    }

    @Test
    @DisplayName("Test que comprueba una BadRequest al cobrar peaje")
    public void testCollectTollError() {
        
        doThrow(new RuntimeException()).when(tollStation).collectToll(car);

        ResponseEntity<?> response = controller.collectToll(car);

        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }
}