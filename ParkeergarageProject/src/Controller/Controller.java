package Controller;


import Controller.AbstractController;
import Model.Simulator;

import javax.swing.*;

import java.awt.Color;

import java.awt.event.*;

public class Controller extends AbstractController implements ActionListener {
	private JButton een;
	private JButton honderd;
	private JButton start;
	private JButton stop;
	private ActionEvent event;
	private Simulator simulator;

public Controller(Simulator simulator) {
		super(simulator);

    	setBackground(Color.LIGHT_GRAY);
    	setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,8));
    	
    	een = new JButton("One Step");
    	een.addActionListener((ActionListener) this);
        een.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(een);
         
        honderd= new JButton("Hunderd Step");
        honderd.addActionListener((ActionListener) this);
        honderd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(honderd);
       
        start= new JButton("Start");
        start.addActionListener((ActionListener) this);
        honderd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(start);
       
        stop= new JButton("Stop");
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
	// sets the received actionEvent, and creates a new thread.
	setActionEvent(e);
	Thread performerThread = new Thread(){
		

		 public void run (){
			ActionEvent e = getActionEvent();
			String command = e.getActionCommand();
			if (command == "One Step"){
				Simulator.runCommand(1);
			} 
			if (command == "Hunderd Step"){
				Simulator.runCommand(100);
				}

	//public void run(){
	//ActionEvent e = getActionEvent();
	//String command = e.getActionCommand();
	//	if (command == "+100"){
	//		simulator.runCommand(100);
	//	}
	//	if (command == "+1"){
	//		simulator.runCommand(1);
	//	}
	//	if (command == "Start"){
	//		//controller.run();
	//	}
	//	if (command == "Stop"){
	//		simulator.runCommand(0);
	//	}
	//}
		
		}
		};
	performerThread.start();
}
}




