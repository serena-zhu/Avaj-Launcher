package launcher.avaj.simulator;

import launcher.avaj.simulator.aircraft.Coordinates;
import launcher.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates) {
		WeatherProvider weatherProvider = WeatherProvider.getProvider();
		String weather = weatherProvider.getCurrentWeather(coordinates);
		return weather;
	}

	void changeWeather() {
		this.conditionsChanged();
	}
}