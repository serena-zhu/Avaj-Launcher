package launcher.avaj.simulator;

import launcher.avaj.simulator.aircraft.Flyable;

import java.util.List;
import java.util.ArrayList;

abstract class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
   		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		for (Flyable flyable : this.observers) {
			flyable.updateConditions();
		}
	}
}