
package View;

import java.awt.*;
import javax.swing.*;

import Model.Simulator;


public class CirkelDiagramView extends AbstractView{
		protected MyComponent mycomponent;
		double value;
		Color color;
	   
	   public CirkelDiagramView(double value, Color color) {  
	      super(simulator);
		  this.value = value;
	      this.color = color;
	      
	      
	      // JPanel cirkel = new JPanel(new BorderLayout());
	      // cirkel.setBorder(someBorder);
	      //  cirkel.add(MyComponent, BorderLayout.CENTER);
	      //  topLevelContainer.cirkel(contentPane);
	      //JFrame test = new JFrame();
	      //test.getContentPane().add(new MyComponent());
	      //test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      // test.
	      setSize(200, 200);
	      //test.setResizable(false);
	      // test.setLayout(null);
	      // test.setBounds(230, 10, 200, 200);
	      // test.setVisible(true);
	   }
	}
	class MyComponent extends JComponent {
		CirkelDiagramView[] slices = { 
	      new CirkelDiagramView(5, Color.black), new CirkelDiagramView(33, Color.green), new CirkelDiagramView(20, Color.yellow), new CirkelDiagramView(15, Color.red) 
	   };
	   MyComponent() {}
	   public void paint(Graphics g) {
	      drawPie((Graphics2D) g, getBounds(), slices);
	   }
	   void drawPie(Graphics2D g, Rectangle area, CirkelDiagramView[] slices) {
	      double total = 0.0D;
	      
	      for (int i = 0; i < slices.length; i++) {
	         total += slices[i].value;
	      }
	      double curValue = 0.0D;
	      int startAngle = 0;
	      for (int i = 0; i < slices.length; i++) {
	         startAngle = (int) (curValue * 360 / total);
	         int arcAngle = (int) (slices[i].value * 360 / total);
	         g.setColor(slices[i].color);
	         g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
	         curValue += slices[i].value;
	      }
	   }
	}
