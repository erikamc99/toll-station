package dev.erika.toll_station;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.erika.toll_station.tollstation.controller.TollStationController;
import dev.erika.toll_station.tollstation.model.TollStation;
import dev.erika.toll_station.vehicles.model.Car;
import dev.erika.toll_station.vehicles.model.Motorbike;
import dev.erika.toll_station.vehicles.model.Truck;

@SpringBootApplication
public class TollStationApplication {

	public static void main(String[] args) {
		TollStation tollStation = new TollStation("Autogrill", "Sagunto");
		TollStationController controller = new TollStationController(tollStation);
		Car car = new Car("1234ABC");
		Motorbike moto = new Motorbike("5678DEF");
		Truck truck = new Truck("1234DEF", (int) (Math.random() * 10) + 1);
		Truck truck2 = new Truck("1234GHI", (int) (Math.random() * 10) + 1);

		controller.collectToll(car);
		controller.collectToll(moto);
		controller.collectToll(truck);
		controller.collectToll(truck2);
		System.out.println(controller.printReport());
	}
}