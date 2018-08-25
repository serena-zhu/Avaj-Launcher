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
		
			BufferedReader reader = new BufferedReader(new FileReader(args[0])); 
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			WeatherTower weatherTower = new WeatherTower();

			// loop through all aircrafts...

			Flyable flyable;

			String type = "balloon";
			System.out.printf("Will try to create a %s...%n", type);
			flyable = AircraftFactory.newAircraft(type, "hi", 36, 80, 18);
			flyable.registerTower(weatherTower);

			type = "jetplane";
			System.out.printf("Will try to create a %s...%n", type);
			flyable = AircraftFactory.newAircraft(type, "hiagain", 12, 600, 18);
			flyable.registerTower(weatherTower);
			// all aircrafts created and registered...

			//change weather each day
			weatherTower.changeWeather();
		} catch (FileNotFoundException e) {
			System.out.printf("File %s not found.%n", args[0]);
		} catch (IOException e) {
			System.out.printf("Error reading file %s.%n", args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please provide scenario file for simulation.");
		}
	}
}