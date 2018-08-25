package launcher.avaj.simulator;

import launcher.avaj.simulator.aircraft.AircraftFactory;
import launcher.avaj.simulator.aircraft.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.InterruptedException;

public class Simulator {
	public static void main(String[] args) throws InterruptedException {
		try {
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
				if (data.length >= 5) {
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
}