package launcher.avaj.weather;

import launcher.avaj.simulator.aircraft.Coordinates;

import java.util.Random;

public final class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static String weather;

	private WeatherProvider() {

	}

	public static WeatherProvider getProvider() {
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {

		Random rand = new Random();

		int weatherKey = (coordinates.getLongitude() + coordinates.getLatitude() 
							+ coordinates.getHeight()) * rand.nextInt(100) % 4;

		switch(weatherKey) {
			case 0:
				this.weather = "rain";
				break;
			case 1:
				this.weather = "fog";
				break;
			case 2:
				this.weather = "sun";
				break;
			case 3:
				this.weather = "snow";
				break;
			default:
				this.weather = "sun";
		}
		return this.weather;
	}

}