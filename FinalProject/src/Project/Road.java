package Project;

public class Road {
	
	private double length;
	private Junction start;
	private Junction end;
	
	public Road(Junction St , Junction En) {
		if (St != En) {
			this.start = St;
			this.end = En;
		}
		else {
			this.start = St;
			this.end = new Junction();
			System.out.println("Road can not connect junction to itself, the end junction has been replaced with " + end);
		}
		start.addExitingRoad(this);
		end.addEnteringRoad(this);
		this.length = this.start.calcDistance(this.end);
		System.out.printf("Creating " + this + ", length: %.2f \n",this.length);
	}

	public String toString() {
		return "Road from " + start + " to " + end;
	}

	public double getLength() {
		return length;
	}

	public Junction getStart() {
		return start;
	}

	public Junction getEnd() {
		return end;
	}
}
