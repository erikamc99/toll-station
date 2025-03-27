package dev.erika.toll_station.tollstation.model;

public class TollStation {

    private final String name;
    private final String city;

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
}
