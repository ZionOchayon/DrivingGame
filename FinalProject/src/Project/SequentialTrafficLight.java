package Project;

public class SequentialTrafficLight extends TrafficLight {
	
	private int id = 0;
	
	public SequentialTrafficLight(Junction juncofTrafficLight) {
		super(juncofTrafficLight);
	}

	public void chengeLight() {
		setCurrentGreen(getJuncofTrafficLight().getEnteringRoad().get(id));
		System.out.println(this);
		if (id<getJuncofTrafficLight().getEnteringRoad().size()-1) {
			id++;
		}else {
			id = 0;
		}
	}
	
	public String toString() {
		return "Sequential TrafficLight " + getJuncofTrafficLight() + ", delay= " + getDelay() 
				+ ": green light on " + getCurrentGreen();
	}
}
