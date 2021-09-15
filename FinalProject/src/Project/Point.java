package Project;
import java.util.Random;

public class Point {
	private final int MAX_X = 800;
	private final int MAX_Y = 600;
	private final int MIN_VAL = 0;
	
	private double x;
	private double y;
	
	public Point () {
		Random rand = new Random();
		x = rand.nextInt(MAX_X) + rand.nextDouble();
		y = rand.nextInt(MAX_Y) + rand.nextDouble();
		if (this instanceof Junction == false) {
			System.out.printf("Creating " + this + "\n",x,y);
		}
	}
	
	public Point (double x, double y) {
			this.x = tryCatch(x,MAX_X,"x");
			this.y = tryCatch(y, MAX_Y,"y");
			if (this instanceof Junction == false) {
				System.out.printf("Creating " + this + "\n",this.x,this.y);
			}
   	}
	
	private double tryCatch(double num, int max ,String operator){
		try {
			checkVal(num,max,operator);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			num = fixVal(num,max);
			System.out.println(num);
		}
		return num;
	}
	
	private void checkVal(double num, int max ,String operator) throws Exception{
			if(num<MIN_VAL|| num>max) {
				throw new Exception(num + " is illiegal value for " + operator + " and has been replaced with ");
			}
	}
	
	private double fixVal(double num, int max) {
		Random rand = new Random();
		num = rand.nextInt(max) + rand.nextDouble();
		return num;
	}

	public double calcDistance (Point other) {
		return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));	
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public String toString() {
		return "Point (%.2f, %.2f)";
	}
}
