package Model;


import java.util.Random;
import java.awt.*;

/*
 * This is class ParkingPassCar
 * This is the class which makes parkingpasses for car
 * @author Daniël Bouius, Arneld van der Veen, Albert van der Berg, Antonie Groenveld, Martijn Bakker
 */

public class ParkingPassCar extends Car {
	private static final Color COLOR=Color.blue;
	
	/**
	 * Constructs for ParkingPassCar
	 */
	
    public ParkingPassCar() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(false);
    }
    
    public Color getColor(){
    	return COLOR;
    }
}
