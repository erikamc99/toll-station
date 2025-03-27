package dev.erika.toll_station.tollstation.model;

import java.util.ArrayList;
import java.util.List;

import dev.erika.toll_station.vehicles.model.Vehicle;

public class TollStation {

    private final String name;
    private final String city;
    private final List<Vehicle> vehicles = new ArrayList<>();

    public TollStation(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
