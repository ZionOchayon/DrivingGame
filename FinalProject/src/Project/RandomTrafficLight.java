package Project;

import java.util.Random;

public class RandomTrafficLight extends TrafficLight {
	
	public RandomTrafficLight(Junction juncofTrafficLight) {
		super(juncofTrafficLight);
	}
	
	public void chengeLight() {
		Random rand = new Random();
		setCurrentGreen(getJuncofTrafficLight().getEnteringRoad().get(rand.nextInt(getJuncofTrafficLight().getEnteringRoad().size())));
		System.out.println(this);
	}
	
	public String toString() {
		return "Random TrafficLight " + getJuncofTrafficLight() + ", delay= " + getDelay() 
				+ ": green light on " + getCurrentGreen();
	}
}
