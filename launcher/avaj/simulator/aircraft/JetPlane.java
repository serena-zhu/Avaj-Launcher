package launcher.avaj.simulator.aircraft;

import launcher.avaj.simulator.WeatherTower;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
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

				writer.printf("JetPlane#%s(%d): landing at %d, %d, 0 (long, lat, ht). %n", 
								this.name, this.id, longitude, latitude);
				writer.printf("Tower says: JetPlane#%s(%d) unregistered from weather tower. %n",
								this.name, this.id);
			} else {
				this.coordinates = new Coordinates(longitude, latitude, height);

				writer.printf("JetPlane#%s(%d): %s %n", this.name, this.id, message);
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

			writer.printf("Tower says: JetPlane#%s(%d) registered to weather tower. %n",
							this.name, this.id);
			writer.close();
		} catch (IOException e) {
			System.out.println("Error creating results file");
			System.exit(1);
		}
	}
}