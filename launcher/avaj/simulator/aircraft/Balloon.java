package launcher.avaj.simulator.aircraft;

import launcher.avaj.simulator.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Balloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		String message = "";

		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		// System.out.printf("Current long lat height are: %d %d %d %n", 
		// 				longitude, latitude, height);

		// System.out.printf("The weather is %s %n", weather);

		switch (weather) {
			case "sun":
				longitude += 2;
				height += 4;
				message = "Let's enjoy the good weather and take some pics.";
				break;
			case "rain":
				height -= 5;
				message = "Darn you rain! You messed up my balloon.";
				break;
			case "fog":
				height -= 3;
				message = "It's so hard to see through this fog.";
				break;
			case "snow":
				height -= 15;
				message = "This is way too cold.";
				break;
		}

		if (height > 100) {
			height = 100;
		}

		if (height <= 0) {
			weatherTower.unregister(this);
			System.out.printf("Balloon#%s(%d): landing at %d, %d, 0 (long, lat, ht). %n", 
							this.name, this.id, longitude, latitude);
			System.out.printf("Tower says: Balloon#%s(%d) unregistered from weather tower. %n",
							this.name, this.id);
			// System.out.printf("%-12s %s %s(%d) %s %n %-11s %s %d, %d, 0 (long, lat, ht). %n",
			// 				"Tower says: ", "Ballon#", this.name, this.id, 
			// 				"unregistered from weather tower.", "",
			// 				"Its current coordinates are: ", longitude, latitude);
		} else {
			this.coordinates = new Coordinates(longitude, latitude, height);

			System.out.printf("Balloon#%s(%d): %s %n", this.name, this.id, message);
		}

		// System.out.printf("New long lat height are: %d %d %d %n", 
		// 				this.coordinates.getLongitude(), 
		// 				this.coordinates.getLatitude(),
		// 				this.coordinates.getHeight());
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);


		System.out.printf("Tower says: Balloon#%s(%d) registered to weather tower. %n",
						this.name, this.id);

		// System.out.printf("%-12s %s %s(%d) %s %n",
		// 				"Tower says: ", "Balloon#", this.name, this.id,
		// 				"registered to the weather tower.");
	}

}