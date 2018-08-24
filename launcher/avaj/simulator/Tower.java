package launcher.avaj.simulator;

import launcher.avaj.simulator.aircraft.Flyable;

import java.util.List;
import java.util.ArrayList;

abstract class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		System.out.println("registering...");
   		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		System.out.println("im here");
		for (Flyable flyable : this.observers) {
			System.out.println("looping through observers");
			flyable.updateConditions();
		}
	}
}