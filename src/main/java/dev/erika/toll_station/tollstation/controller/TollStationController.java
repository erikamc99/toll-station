package dev.erika.toll_station.tollstation.controller;


import org.springframework.http.ResponseEntity;
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
}
