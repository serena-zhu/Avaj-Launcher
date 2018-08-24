package launcher.avaj.simulator.aircraft;

import launcher.avaj.simulator.WeatherTower;

public interface Flyable {
	public void updateConditions();

	public void registerTower(WeatherTower WeatherTower);
}