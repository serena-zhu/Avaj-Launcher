package launcher.avaj.simulator.aircraft;

import launcher.avaj.simulator.WeatherTower;

interface Flyable {
	public void updateConditions();

	public void registerTower(WeatherTower WeatherTower);
}