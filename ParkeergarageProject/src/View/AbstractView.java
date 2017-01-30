package View;

import javax.swing.*;
import Model.*;
import Controller.*;

public abstract class AbstractView extends JFrame {
	protected Simulator simulator;

	public AbstractView(Simulator simulator) {
		this.simulator=simulator;
		simulator.addView(this);
	}
	
	public Simulator getModel() {
		return simulator;
	}
	
	public void updateView() {
		repaint();
	}
private void updateViews(){
	simulator.tick();
    // Update the car park view.
    updateView();	
}
}