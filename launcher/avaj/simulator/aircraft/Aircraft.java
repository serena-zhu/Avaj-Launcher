package launcher.avaj.simulator.aircraft;

abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	public long idCounter;

	protected Aircraft(String name, Coordinates coordinates) {

	}

	public long nextId() {
		
	}
}