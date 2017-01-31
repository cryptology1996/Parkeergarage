package View;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
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
		
	}
	
	public void updateView(){

		aantalAdHoc = simulator.getAdHoc()-1;
		aantalPassCar = simulator.getPassCar()-1;
		aantalReserved = simulator.getSubCar()-1;
		repaint();
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 200, 200);
		g.setColor(Color.red);
		g.fillArc(10, 10, 180, 180, 0, aantalAdHoc);
		g.setColor(Color.blue);
		g.fillArc(10, 10, 180, 180, aantalAdHoc, aantalPassCar);
		g.setColor(Color.black);
		g.fillArc(10, 10, 180, 180, aantalAdHoc+aantalPassCar, aantalReserved);
		
		// totaal = aantalAdHoc + AantalPassCar +  AantalReserved
		// Aantaladhoc % totaal
		// AantalPassCar % totaal
		// AantalReserved % totaal
	}	
}