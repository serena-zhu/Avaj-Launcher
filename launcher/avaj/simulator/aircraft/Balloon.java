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

		this.coordinates = new Coordinates(longitude, latitude, height);

		System.out.printf("New long lat height are: %d %d %d %n", 
						this.coordinates.getLongitude(), 
						this.coordinates.getLatitude(),
						this.coordinates.getHeight());
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		System.out.println("hiiiii");
		this.weatherTower = weatherTower;
		System.out.println("calling Tower's regirster method...");
		weatherTower.register(this);
	}

}