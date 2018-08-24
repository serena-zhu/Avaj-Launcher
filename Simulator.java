import launcher.avaj.simulator.aircraft.AircraftFactory;
import launcher.avaj.simulator.aircraft.Flyable;

public class Simulator {
	public static void main(String[] args) {
		Flyable flyable;

		String type = "balloon";
		System.out.printf("Will try to create a %s...%n", type);
		flyable = AircraftFactory.newAircraft(type, "hi", 6, 80, 35);
	}
}