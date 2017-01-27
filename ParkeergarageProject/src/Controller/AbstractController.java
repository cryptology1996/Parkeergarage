package Controller;

import javax.swing.*;
import Model.*;

public abstract class AbstractController extends JPanel {
	protected Simulator model;
	
	public AbstractController(Simulator model) {
		this.model=model;
	}
}
