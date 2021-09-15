package Project;

import java.util.ArrayList;
import java.util.Random;

public class Map{
	
	private ArrayList<Junction> junc = new ArrayList<Junction>();
	private ArrayList<Road> road = new ArrayList<Road>();
	
	public Map(ArrayList<Junction> juncs, ArrayList<Road> roads ) {
		junc = juncs;
		road = roads;
		createTrafficLights();
	}
	
	public Map(int numOfjuncs) {
		for (int i = 0; i<numOfjuncs; i++) {
			junc.add(new Junction());
		}
		createRoads();
		createTrafficLights();
	}
	
	private void createTrafficLights() {
		Random rand = new Random();
		for (Junction junc : junc) {
			if(junc.getEnteringRoad().size() > 0 && rand.nextBoolean() && rand.nextBoolean()) {
				if (rand.nextBoolean()) {
					junc.setRamzor(new RandomTrafficLight(junc));
				}
				else {
					junc.setRamzor(new SequentialTrafficLight(junc));
				}
			}
		}
	}
	
	private void createRoads() {
		Random rand = new Random();
		for (Junction start : junc) {
			for( Junction end : junc ) {
				if (start != end && rand.nextBoolean()) {
					Road newRoad = new Road(start , end);
					road.add(newRoad);
				}
			}
		}
	}
	
	public ArrayList<Junction> getJunc() {
		return junc;
	}
	
	public ArrayList<Road> getRoad() {
		return road;
	}
	
	private Junction RandomJunc() {
		Random rand = new Random();
		return junc.get(rand.nextInt(junc.size()-1));
		
	}

	public ArrayList<Road> RandomPath() {
		Random rand = new Random();
		ArrayList<Road> path = new ArrayList<Road>();
		Junction start;
		do {
			start = RandomJunc();
		}
		while (start.getExitingRoad().size() < 1);
		do {
			path.add(start.getExitingRoad().get(rand.nextInt(start.getExitingRoad().size())));
			start = path.get(path.size()-1).getEnd();
		}
		while(start.getExitingRoad().size() > 0 && path.size() < 4);				
		return path;
	}	
}
