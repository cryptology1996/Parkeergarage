package Controller;

import Controller.AbstractController;
import Model.Simulator;

public class Controller extends AbstractController {

public Controller(Simulator model) {
		super(model);
		
	}
public void run() {
    for (int i = 0; i < 10000; i++) {
        model.tick();
    }
}
}
