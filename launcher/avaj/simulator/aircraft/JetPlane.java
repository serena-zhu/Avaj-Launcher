package launcher.avaj.simulator.aircraft;

import launcher.avaj.simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
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