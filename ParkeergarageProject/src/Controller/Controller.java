package Controller;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;

import Model.Simulator;
import Controller.AbstractController;

/**
 * This is class Controller for Simulator 
 * Contains the buttons for the simulator with its ActionListener and ActionEvent
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public class Controller extends AbstractController implements ActionListener {
	private JButton een;
	private JButton honderd;
	private JButton start;
	private JButton stop;
	private ActionEvent event;
	private Simulator simulator;
	
/**
* Constructs an instance of the Controller
* and add the buttons 1 step, 100 steps, start an stop to simulator 
*/
	
public Controller(Simulator simulator) {
		super(simulator);

    	setBackground(Color.LIGHT_GRAY);
    	setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,8));
    	
    	een = new JButton("One Step");
    	een.addActionListener((ActionListener) this);
        een.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(een);
         
        honderd= new JButton("Hundred Step");
        honderd.addActionListener((ActionListener) this);
        honderd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(honderd);
       
        start= new JButton("Start");
        start.addActionListener((ActionListener) this);
        honderd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(start);
       
        stop= new JButton("Reset");
        stop.addActionListener((ActionListener) this);
        honderd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(stop);
        
        setVisible(true);
		
	}

/**
 * sets ActionEvent to e
 * @ActionEvent = e
 * @event = e
 */

public void setActionEvent(ActionEvent e) {
	event = e;
}

/**
 * returns the set event
 * @return event
 */

public ActionEvent getActionEvent() {
	return event;
}

/**
 * Executes the the input action
 */

public void actionPerformed(ActionEvent e)
{
	
	// sets the received actionEvent, and creates a new thread
	setActionEvent(e);
	Thread performerThread = new Thread(){
		

		 public void run (){
			ActionEvent e = getActionEvent();
			String command = e.getActionCommand();
			if (command == "One Step"){
				Simulator.runCommand(1);
			} 
			if (command == "Hundred Step"){
				Simulator.runCommand(100);
				}
			if (command == "Start"){
				Simulator.runCommand(100000);
			}
			if (command == "Reset"){
				try {
					Runtime.getRuntime().exec("java -jar Parkeergarage.jar");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			     System.exit(1);
				
			}

		}
		};
		performerThread.start();
}

}




