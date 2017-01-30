package Controller;

import javax.swing.*;

import Model.*;

/**
 * Abstract Class for the controller
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public abstract class AbstractController extends JPanel {
	protected Simulator simulator;
	
	
	/**
	 * Constructor for AbstractController
	 */
	
	public AbstractController(Simulator simulator) {
		this.simulator=simulator;
	}
}
