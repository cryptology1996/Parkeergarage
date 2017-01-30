package Main;

import Controller.*;
import Model.*;

/**
 * Main class to run the project
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 * 
 */

public class Main {
	
	// run the java program
	public static void main(String[] args) {
			Simulator simulator = new Simulator();
		    Controller controller = new Controller(simulator);
	}

}
