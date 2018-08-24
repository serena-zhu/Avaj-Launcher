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

		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		System.out.printf("Current long lat height are: %d %d %d %n", 
						longitude, latitude, height);

		System.out.printf("The weather is %s %n", weather);

		switch (weather) {
			case "sun":
				longitude += 2;
				height += 4;
				break;
			case "rain":
				height -= 5;
				break;
			case "fog":
				height -= 3;
				break;
			case "snow":
				height -= 15;
				break;
		}

		if (height > 100) {
			height = 100;
		} else if (height <= 0) {
			weatherTower.unregister(this);
			System.out.printf("Need to unregister %n");
			//print unregister message
		} else {
			this.coordinates = new Coordinates(longitude, latitude, height);
		}

		System.out.printf("New long lat height are: %d %d %d %n", 
						this.coordinates.getLongitude(), 
						this.coordinates.getLatitude(),
						this.coordinates.getHeight());

		//Need to log a message each time a weather change occurs with TYPE#NAME(UNIQUE_ID) : SPECIFIC_MESSAGE
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);

		System.out.printf("Tower says: Balloon#%s(%d) registered to the weather tower.", this.name, this.id);
	}

}