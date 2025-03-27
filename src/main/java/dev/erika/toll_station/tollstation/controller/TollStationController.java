package dev.erika.toll_station.tollstation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.erika.toll_station.tollstation.model.TollStation;
import dev.erika.toll_station.vehicles.model.Vehicle;

public class TollStationController {
    private final TollStation tollStation;

    public TollStationController(TollStation tollStation) {
        this.tollStation = tollStation;
    }

    @PostMapping("/toll")
    public ResponseEntity<?> collectToll(@RequestBody Vehicle vehicle) {
        try {
            tollStation.collectToll(vehicle);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/report")
    public ResponseEntity<String> printReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== Reporte de: ")
        .append(tollStation.getName()).append(", ")
        .append(tollStation.getCity()).append(" ===\n");
        report.append("Vehículos atendidos:\n");

        for (Vehicle v : tollStation.getVehicles()) {
            report.append("Matrícula: ").append(v.getPlate())
                  .append(", Peaje: ").append(v.calculateToll()).append("€\n");
        }

        int totalToll = tollStation.getVehicles().stream().mapToInt(Vehicle::calculateToll).sum();
        report.append("\nTotal recolectado: ").append(totalToll).append("€");

        return ResponseEntity.ok(report.toString());
    }
}