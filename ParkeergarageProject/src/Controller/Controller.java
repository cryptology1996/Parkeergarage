package Controller;


import Controller.AbstractController;
import Model.Simulator;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class Controller extends AbstractController {
	
	private JButton een;
	private JButton honderd;
	private JButton start;
	private JButton stop;

public Controller(Simulator model) {
		super(model);
    	setBackground(Color.LIGHT_GRAY);
    	setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,8));
    	
    	een = new JButton("+1");
        een.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(een);
         
        honderd= new JButton("+100");
        honderd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(honderd);
       
        start= new JButton("Start");
        honderd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(start);
       
        stop= new JButton("Stop");
        honderd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        add(stop);
        
           setVisible(true);
		
	}
public void run() {
    for (int i = 0; i < 10000; i++) {
        model.tick();
    }
}
}

