package launcher.avaj.simulator.aircraft;

public abstract class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Flyable flyable;
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		switch (type.toLowerCase()) {
			case "helicopter":
				 flyable = new Helicopter(name, coordinates);
				break;
			case "jetplane":
				flyable = new JetPlane(name, coordinates);
				break;
			case "balloon":
				flyable = new Balloon(name, coordinates);
				break;
			default:
				System.out.println("im null");
				flyable = null;
		}

		return flyable;
	}
}