package Main;

import Controller.*;
import Model.*;
public class Main {

	public static void main(String[] args) {
			Simulator simulator = new Simulator();
		    Controller controller = new Controller(simulator);
		    controller.run();
	}

}
