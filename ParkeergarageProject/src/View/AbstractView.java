package View;

import javax.swing.*;

import Model.*;

/**
 * Abstract class for the View subclasses
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public abstract class AbstractView extends JFrame {
	protected static Simulator simulator;

	public AbstractView(Simulator simulator) {
		this.simulator=simulator;
		simulator.addView(this);
	}
	
	public Simulator getModel() {
		return simulator;
	}
	
// 	Repaints the car park view
	public void updateView() {
		repaint();
	}
	
// 	Update the car park view. Test for reset
//	private void updateViews(){
//	simulator.tick();
// 	
//   updateView();	
//}
}