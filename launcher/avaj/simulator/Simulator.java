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

				if  (!isValidAircraft(data)) {
					System.out.println("Invalid description of aircraft. Exiting.");
					System.exit(1);
				}

				flyable = AircraftFactory.newAircraft(data[0].toLowerCase(), data[1], 
													Integer.parseInt(data[2]), 
													Integer.parseInt(data[3]),
													Integer.parseInt(data[4]));

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

		int tmp;

		if (data.length < 5) {
			return false;
		}

		if (!data[2].matches("\\d+") || !data[3].matches("\\d+") || !data[4].matches("\\d+")) {
			return false;
		}

		// tmp = Integer.parseInt(data[2]);
		// if (tmp < -180 || tmp > 180) {
		// 	System.out.println("1");
		// 	return false;
		// }

		// tmp = Integer.parseInt(data[3]);
		// if (tmp < -90 || tmp > 90) {
		// 	System.out.println("2");
		// 	return false;
		// }

		// tmp = Integer.parseInt(data[4]);
		// if (tmp < 0 || tmp > 0) {
		// 	System.out.println("3");
		// 	return false;
		// }

		if (!(data[0].equalsIgnoreCase("balloon") || data[0].equalsIgnoreCase("helicopter")
				|| data[0].equalsIgnoreCase("jetplane"))) {
			return false;
		}

		return true;
	}
}