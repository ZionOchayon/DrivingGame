package Project;

import java.util.Random;

public abstract class TrafficLight implements Dynamic{
	
	private Junction juncofTrafficLight;
	private Road CurrentGreen;
	
	private int delay;
	private int turns = 1;

	public TrafficLight(Junction juncofTrafficLight) {
		Random rand = new Random();
		this.delay = rand.nextInt(3)+2;
		this.juncofTrafficLight = juncofTrafficLight;
		this.chengeLight();
	}
	
	public void work() {
		if (turns%delay==0) {
			chengeLight();
		}
		turns++;
	}

	public Road getCurrentGreen() {
		return CurrentGreen;
	}
	public void setCurrentGreen(Road currentGreen) {
		CurrentGreen = currentGreen;
	}

	public Junction getJuncofTrafficLight() {
		return juncofTrafficLight;
	}
	
	public int getDelay() {
		return delay;
	}

	public abstract void chengeLight();
}
