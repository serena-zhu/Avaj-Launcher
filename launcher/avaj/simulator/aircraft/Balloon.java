package launcher.avaj.simulator.aircraft;

import launcher.avaj.simulator.WeatherTower;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Balloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Balloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		try {

			PrintWriter writer = new PrintWriter(new FileWriter("simulation.txt", true));

			String weather = weatherTower.getWeather(this.coordinates);
			String message = "";

			int longitude = this.coordinates.getLongitude();
			int latitude = this.coordinates.getLatitude();
			int height = this.coordinates.getHeight();

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

				writer.printf("Balloon#%s(%d): landing at %d, %d, 0 (long, lat, ht). %n", 
								this.name, this.id, longitude, latitude);
				writer.printf("Tower says: Balloon#%s(%d) unregistered from weather tower. %n",
								this.name, this.id);
			} else {
				this.coordinates = new Coordinates(longitude, latitude, height);

				writer.printf("Balloon#%s(%d): %s %n", this.name, this.id, message);
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Error creating results file");
			System.exit(1);
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		try {

			PrintWriter writer = new PrintWriter(new FileWriter("simulation.txt", true));

			this.weatherTower = weatherTower;
			weatherTower.register(this);

			writer.printf("Tower says: Balloon#%s(%d) registered to weather tower. %n",
							this.name, this.id);
			writer.close();
		} catch (IOException e) {
			System.out.println("Error creating results file");
			System.exit(1);
		}
	}
}