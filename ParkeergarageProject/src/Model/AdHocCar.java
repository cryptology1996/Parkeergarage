package Model;

import java.util.Random;
import java.awt.*;

/**
 * Class for adHocCar when they enter an how long the stay
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public class AdHocCar extends Car {
	private static final Color COLOR=Color.red;
	
	/**
	 * creates an instance of AdHocCar
	 */
	
    public AdHocCar() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    public Color getColor(){
    	return COLOR;
    }
}
