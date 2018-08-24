package launcher.avaj.simulator.aircraft;

import launcher.avaj.simulator.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Balloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		;
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		;
	}

}