package Controller;

import javax.swing.*;
import Model.*;

public abstract class AbstractController extends JPanel {
	protected Simulator simulator;
	
	public AbstractController(Simulator simulator) {
		this.simulator=simulator;
	}
}
