package Project;

import java.util.ArrayList;

public class Passenger {
	
	private static int counter = 1;
	private int id;
	
	private ArrayList<Road> path;
	
	public Passenger(Map map) {
		this.id = counter ++;
		this.path = map.RandomPath();
		this.path.get(0).getStart().addPassengers(this);
		System.out.println(this);
	}

	public ArrayList<Road> getPath() {
		return path;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Passenger " + id + " is waiting for vehicle at " + path.get(0).getStart() + " path: " + path;
	}
}
