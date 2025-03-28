package dev.erika.toll_station.vehicles.model;

public class Truck extends Vehicle {
    private final int axles;

    public Truck(String plate, int axles) {
        super(plate);
        this.axles = axles;
    }

    @Override
    public int calculateToll() {
        return 50 * axles;
    }
}
