package Model;
/*
 * Dit is de klasse die de automobilisten met een parkingpass aanmaakt.
 * @author Daniël Bouius, Arneld van der Veen, Albert van der Berg, Antonie Groenveld, Martijn Bakker
 */
import java.util.Random;
import java.awt.*;

public class ParkingPassCar extends Car {
	private static final Color COLOR=Color.blue;
	
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
