package Project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DrivingGame {
	
	private int turns = 1;
	private int numVehicles;
	
	private Map gameMap;	
	ArrayList<Dynamic> vehiclesAndLigths = new ArrayList<Dynamic>();
	
	public DrivingGame(int juncs , int numVehicles) {
		this.numVehicles = numVehicles;
		this.gameMap = new Map(juncs);
		for(int i = 0; i<numVehicles ; i++) {
			Vehicle vehicle = new Vehicle(gameMap) ;
			vehiclesAndLigths.add(vehicle);
		}
		for(Junction junc : gameMap.getJunc()) {
			if(junc.getRamzor() != null) {
				vehiclesAndLigths.add(junc.getRamzor());
			}
		}	
	}
	
	public void play() {
		openFile();
		while(Vehicle.getGameRuning() != numVehicles){
			System.out.println("\nTurn "+ turns);
			for(Dynamic vehicleOrLigth : vehiclesAndLigths) {
				vehicleOrLigth.work();
			}
			if(turns%3 == 0) {
				new Passenger(gameMap);
			}
			turns++;
		}	
	}
	
	private void openFile() {
		File file = new File("report.txt");
		FileWriter out = null;
		String toWrite = "   Vehicle   |   Passenger   |     From     |     To    \n"
					   + "-------------|---------------|--------------|------------\n";
		try {
			out = new FileWriter(file);
			out.write(toWrite);
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
}