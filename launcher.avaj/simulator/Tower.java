package launcher.avaj.simulator;

import launcher.avaj.simulator.aircraft.Flyable;

import java.util.List;

abstract class Tower {
	private List<Flyable> observers;

	public void register(Flyable flyable) {

	}

	public void unregister(Flyable flyable) {

	}

	protected void conditionsChanged() {

	}
}