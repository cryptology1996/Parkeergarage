package Model;

import java.util.*;

import View.*;

/**
 * Abstract Class for the model subclasses
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public abstract class AbstractModel {
	private List<AbstractView> views;
	
	
	/**
	 * constructor for AbstractModel
	 */
	
	public AbstractModel() {
		views=new ArrayList<AbstractView>();
	}
	
	public void addView(AbstractView view) {
		views.add(view);
	}
	
	public void notifyViews() {
		for(AbstractView v: views) v.updateView();
	}
}
