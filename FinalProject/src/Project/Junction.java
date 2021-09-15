package Project;
import java.util.ArrayList;

public class Junction extends Point{
	
	private static int counter = 1;
	private int id;
	
	private ArrayList<Road> enteringRoad = new ArrayList<Road>();
	private ArrayList<Road> exitingRoad = new ArrayList<Road>();
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	private TrafficLight ramzor = null;

	public Junction() {
		super();
		id = counter ++;
		System.out.printf("Creating " + this + " at " + super.toString() + "\n",getX(),getY());
	}
	
	public Junction(double x,double y) {
		super(x,y);
		id = counter ++;
		System.out.printf("Creating " + this + " at " + super.toString() + "\n",getX(),getY());	
	}
	
	public void addEnteringRoad(Road road) {
		enteringRoad.add(road);
	}
	
	public void addExitingRoad(Road road) {
		exitingRoad.add(road);
	}
	
	public TrafficLight getRamzor() {
		return ramzor;
	}

	public void setRamzor(TrafficLight ramzor) {
		this.ramzor = ramzor;
	}
	
	public ArrayList<Road> getExitingRoad() {
		return exitingRoad;
	}

	public ArrayList<Road> getEnteringRoad() {
		return enteringRoad;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public void addPassengers(Passenger passenger) {
		passengers.add(passenger);
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return "Junction " + id;
	}
}
