package launcher.avaj.simulator;

import launcher.avaj.simulator.aircraft.AircraftFactory;
import launcher.avaj.simulator.aircraft.Flyable;
// import simulator.WeatherTower;

public class Simulator {
	public static void main(String[] args) {
		WeatherTower weatherTower = new WeatherTower();

		// loop through all aircrafts...

		Flyable flyable;

		String type = "balloon";
		System.out.printf("Will try to create a %s...%n", type);
		flyable = AircraftFactory.newAircraft(type, "hi", 36, 80, 35);
		flyable.registerTower(weatherTower);
		// all aircrafts created and registered...
		
		//change weather each day
		weatherTower.changeWeather();

	}
}