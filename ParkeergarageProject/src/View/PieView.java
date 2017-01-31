package View;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.*;

public class PieView extends JPanel {
	private int aantalAdHoc;
	private int aantalPassCar;
	private Simulator simulator;
	private int aantalReserved;

	public PieView(Simulator simulator) {
		this.simulator = simulator;
		
		JPanel pieView = new JPanel();
		pieView.setLayout(new FlowLayout());
		pieView.setBackground(Color.WHITE);
		JLabel lblPieView = new JLabel("Cars");
		pieView.add(lblPieView);
		this.add(pieView);
		
		aantalAdHoc = simulator.getAdHoc();
		aantalPassCar = simulator.getPassCar();
		aantalReserved = simulator.getSubCar();
	}
	
	public void updateView(){
		repaint();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 200, 200);
		g.setColor(Color.red);
		g.fillArc(10, 10, 180, 180, 0, aantalAdHoc);
		g.setColor(Color.blue);
		g.fillArc(10, 10, 180, 180, aantalAdHoc, aantalPassCar);
		g.setColor(Color.black);
		g.fillArc(10, 10, 180, 180, aantalAdHoc+aantalPassCar, aantalReserved);
	}	
}