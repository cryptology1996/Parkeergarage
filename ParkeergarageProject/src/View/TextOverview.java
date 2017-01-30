package View;
import Model.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextOverview extends JPanel {
	private JTextField txtRevenue;
	private Simulator model;
	double ticketPrice = 7.50;
	
	
	
	/**
	 * Create the frame.
	 */
	public TextOverview(Simulator model) {
		this.model = model;
		this.setLayout(new GridLayout(0,1)); 
		//setBounds(100, 100, 450, 339);
		
		
		
		
		
		JPanel revenue = new JPanel();
		revenue.setLayout(new FlowLayout());
		revenue.setBackground(Color.LIGHT_GRAY);
		JLabel lblRevenue = new JLabel("Total revenue");
		txtRevenue = new JTextField();
		txtRevenue.setEditable(false);
		txtRevenue.setColumns(10);
		txtRevenue.setBackground(Color.LIGHT_GRAY);
		txtRevenue.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		revenue.add(lblRevenue);
		revenue.add(txtRevenue);
		this.add(revenue);
		

		// using the calc function to calc the revenue
		calcRevenue();

	}
	
	/**
	 * updates the values inside the textFields
	 */
	public void updateView(){
		calcRevenue();

	}	
	
	/**
	 * calculates the revenue
	 */
	public void calcRevenue()
	{
	
	int totalCars = model.getPayingCars();	
	double totalRevenue = totalCars * ticketPrice;
			
		txtRevenue.setText(" "+totalRevenue+"$");	
		
	}
	
}
