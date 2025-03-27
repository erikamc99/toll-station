package dev.erika.toll_station.vehicles.model;

public abstract class Vehicle {
    protected final String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public abstract int calculateToll();
}
