package dev.erika.toll_station.vehicles.model;

public class Car extends Vehicle {
    public Car(String plate) {
        super(plate);
    }

    @Override
    public int calculateToll() {
        return 100;
    }
}
