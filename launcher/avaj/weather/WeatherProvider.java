package launcher.avaj.weather;

import launcher.avaj.simulator.aircraft.Coordinates;

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

	// 0 rain
	// 1 fog
	// 2 sun
	// 3 snow
	public String getCurrentWeather(Coordinates coordinates) {
		// Update later
		int weatherKey = (coordinates.getLongitude() + coordinates.getLatitude() 
							+ coordinates.getHeight()) % 4;

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