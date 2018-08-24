package launcher.avaj.simulator.aircraft;

import launcher.avaj.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		String message = "";

		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		switch (weather) {
			case "sun":
				longitude += 10;
				height += 2;
				message = "This is hot.";
				break;
			case "rain":
				height += 5;
				message = "I love rain.";
				break;
			case "fog":
				longitude += 1;
				message = "Everything is the same color.";
				break;
			case "snow":
				height -= 12;
				message = "My rotor is going to freeze!";
				break;
		}

		if (height > 100) {
			height = 100;
		}

		if (height <= 0) {
			weatherTower.unregister(this);
			System.out.printf("Helicopter#%s(%d): landing at %d, %d, 0 (long, lat, ht). %n", 
							this.name, this.id, longitude, latitude);
			System.out.printf("Tower says: Helicopter#%s(%d) unregistered from weather tower. %n",
							this.name, this.id);
		} else {
			this.coordinates = new Coordinates(longitude, latitude, height);

			System.out.printf("Helicopter#%s(%d): %s %n", this.name, this.id, message);
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);

		System.out.printf("Tower says: Helicopter#%s(%d) registered to weather tower. %n",
						this.name, this.id);

	}
}