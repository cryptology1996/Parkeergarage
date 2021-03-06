package Model;

import java.util.Random;
import java.awt.*;

/*
 * This is class SubscriberPassCar
 * @author Dani�l Bouius, Arneld van der Veen, Albert van der Berg, Antonie Groenveld, Martijn Bakker
 */

public class SubscriberPassCar extends Car {
	private static final Color COLOR=Color.black;
	
	/**
	 * Constructor for SubscriberPassCar
	 */
	
    public SubscriberPassCar() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    public Color getColor(){
    	return COLOR;
    }
}
