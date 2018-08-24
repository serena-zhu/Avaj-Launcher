package launcher.avaj.simulator.aircraft;

import launcher.avaj.simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
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
				latitude += 10;
				height += 2;
				message = "It's a great day.";
				break;
			case "rain":
				latitude += 5;
				message = "It's raining. Better watch out for lightnings.";
				break;
			case "fog":
				latitude += 1;
				message = "I'm not afraid of a little fog.";
				break;
			case "snow":
				height -= 7;
				message = "OMG! Winter is coming!";
				break;
		}

		if (height > 100) {
			height = 100;
		}

		if (height <= 0) {
			weatherTower.unregister(this);
			System.out.printf("JetPlane#%s(%d): landing at %d, %d, 0 (long, lat, ht). %n", 
							this.name, this.id, longitude, latitude);
			System.out.printf("Tower says: JetPlane#%s(%d) unregistered from weather tower. %n",
							this.name, this.id);
		} else {
			this.coordinates = new Coordinates(longitude, latitude, height);

			System.out.printf("JetPlane#%s(%d): %s %n", this.name, this.id, message);
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);

		System.out.printf("Tower says: JetPlane#%s(%d) registered to weather tower. %n",
						this.name, this.id);
	}
}