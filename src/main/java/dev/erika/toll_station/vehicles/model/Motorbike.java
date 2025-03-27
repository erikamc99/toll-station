package dev.erika.toll_station.vehicles.model;

public class Motorbike extends Vehicle {
    public Motorbike(String plate) {
        super(plate);
    }

    @Override
    public int calculateToll() {
        return 50;
    }
}
