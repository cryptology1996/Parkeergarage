package View;

import javax.swing.*;
import Model.*;
import Controller.*;

public abstract class AbstractView extends JFrame {
	protected Simulator model;

	public AbstractView(Simulator model) {
		this.model=model;
		model.addView(this);
	}
	
	public Simulator getModel() {
		return model;
	}
	
	public void updateView() {
		repaint();
	}
private void updateViews(){
	model.tick();
    // Update the car park view.
    updateView();	
}
}