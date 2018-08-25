package launcher.avaj.simulator;

import launcher.avaj.simulator.aircraft.Flyable;

// import launcher.avaj.simulator.aircraft.Coordinates;
// import launcher.avaj.simulator.aircraft.Aircraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

abstract class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
   		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		List<Flyable> tmp = new ArrayList<Flyable>(this.observers);

		for (Integer i = 0; i < tmp.size(); i++) {
			tmp.get(i).updateConditions();
		}
	}
}