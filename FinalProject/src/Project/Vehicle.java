package Project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Vehicle implements Dynamic{
	             
	private ArrayList<Road> path;
	private Passenger vehiclePassenger = null;
	
	private boolean arrived = false;
	private static int counter = 1;
	private static int gameRuning = 0;
	private int id;
	private int road = 0;
	private int speed;
	private double distance;  
	
	public Vehicle(Map map) {
		Random rand = new Random();
		this.path = map.RandomPath();
		this.speed = rand.nextInt(91)+30;
		this.distance = path.get(road).getLength();
		this.id = counter++;
		System.out.println("Creating " + this);	
	}

	public void work() {
		if (distance>0) {
			movingTheCar();	
		}else {				
			if(path.get(road).getEnd().getRamzor() != null && road < path.size()-1) {
				if(path.get(road).getEnd().getRamzor().getCurrentGreen() == path.get(road)) {
					road++;
					passengerPickUp(); 
					distance = path.get(road).getLength();
					movingTheCar();
				}else {
					System.out.println("Vehicle " + id + " is waiting for green light on " + path.get(road).getEnd());
				}
			}else if(road < path.size()-1){
					road++;	
					passengerPickUp();
					distance = path.get(road).getLength();
					movingTheCar();
			}else {
				System.out.println("Vehicle " + id + " arrived to it's destination: " + path.get(road).getEnd());
				if (arrived == false) {
					gameRuning++;
					if (vehiclePassenger != null) {
						addToFile();
						System.out.println("Passenger " + vehiclePassenger.getId() + " arrived to the destination with Vehicle " + id);
					}
				}
				arrived = true;
			}
		}
	}
	
	private void movingTheCar() {
		distance-=speed;
		if (distance<0) {
			distance = 0;	
		}
		System.out.println("Vehicle " + id + " moving on the " + path.get(road)+ " avlibale : " + PassCheck());
	}
	
	private void passengerPickUp() {
		if(path.get(road).getEnd().getPassengers().size() > 0 && vehiclePassenger == null) {
			System.out.println(path.get(road).getEnd().getPassengers());//check
			vehiclePassenger = path.get(road).getEnd().getPassengers().remove(0);
		    System.out.println("Vehicle " + id + " is collecting Passenger " + vehiclePassenger.getId() + " at " + vehiclePassenger.getPath().get(0).getStart());
			path = vehiclePassenger.getPath();
			road = 0;			
		}
	}
	
	private String SpaceFix(int num) {
		if (num < 10) {
			return "    |";
		}else {
			return "   |";
		}
	}
	
	private void addToFile() {
		FileWriter out = null;
		try {
			out = new FileWriter("report.txt",true);
			out.write("Vehicle "+ id + SpaceFix(id) +"Passenger "
		               + vehiclePassenger.getId() + SpaceFix(vehiclePassenger.getId())
			           + path.get(0).getStart() + SpaceFix(path.get(0).getStart().getId())
		               + path.get(path.size()-1).getEnd() + "\n");
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (out != null) {
					out.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static int getGameRuning() {
		return gameRuning;
	}

	public String toString() {
		return "Vehicle " + id + ",speed:" + speed + ", path:" + path;
	}
	
	public boolean PassCheck() { //check
		if (vehiclePassenger != null) {
			return false;
		}else {
			return true;
		}
	}
}

