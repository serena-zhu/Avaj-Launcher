package launcher.avaj.simulator.aircraft;

import launcher.avaj.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		;
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		System.out.println("something");
	}
}