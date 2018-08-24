package launcher.avaj.weather;

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

	// 0 Rain
	// 1 Fog
	// 2 Sun
	// 3 Snow
	public String getCurrentWeather(Coordinates coordinates) {
		// Update later
		int weatherKey = (coordinates.getLongitude() + coordinates.getLatitude() + getHeight()) % 4;

		switch(weatherKey) {
			case 0:
				this.weather = "Rain";
				break;
			case 1:
				this.weather = "Fog";
				break;
			case 2:
				this.weather = "Sun";
				break;
			case 3:
				this.weather = "Snow";
				break;
			default:
				this.weather = "Sun";
		}
		return this.weather;
	}

}