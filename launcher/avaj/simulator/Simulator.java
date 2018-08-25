package launcher.avaj.simulator;

import launcher.avaj.simulator.aircraft.AircraftFactory;
import launcher.avaj.simulator.aircraft.Flyable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.InterruptedException;

public class Simulator {
	public static void main(String[] args) throws InterruptedException {
		try {
			File file = new File("simulation.txt");
			file.delete();
			WeatherTower weatherTower = new WeatherTower();
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			int simulationCount;
			String line;
			Flyable flyable;

			simulationCount = Integer.parseInt(reader.readLine());
			if (simulationCount <= 0) {
				System.out.println("Invalid number of simulations, exiting.");
				System.exit(1);
			}

			while ((line = reader.readLine()) != null) {
				flyable = null;
				String[] data = line.split(" ");
				if (isValidAircraft(data)) {
					flyable = AircraftFactory.newAircraft(data[0].toLowerCase(), data[1], 
														Integer.parseInt(data[2]), 
														Integer.parseInt(data[3]),
														Integer.parseInt(data[4]));
				}
				if (flyable != null) {
					flyable.registerTower(weatherTower);
				}
			}

			while (simulationCount > 0) {
				weatherTower.changeWeather();
				simulationCount--;
			}
		} catch (FileNotFoundException e) {
			System.out.printf("File %s not found.%n", args[0]);
		} catch (IOException e) {
			System.out.printf("Error reading file %s.%n", args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please provide scenario file for simulation.");
		}
	}

	public static boolean isValidAircraft(String[] data) {

		//exit if invalid type?
		//exit if invalid number range?

		if (data.length < 5) {
			return false;
		}

		if (!data[2].matches("\\d+") || !data[3].matches("\\d+") || !data[4].matches("\\d+")) {
			return false;
		}

		return true;
	}
}