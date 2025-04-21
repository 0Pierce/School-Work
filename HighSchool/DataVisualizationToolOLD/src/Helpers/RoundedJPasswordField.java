package Helpers;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;

public class RoundedJPasswordField extends JPasswordField {
	
	//This code is from
	//https://www.tutorialspoint.com/how-can-we-implement-a-rounded-jtextfield-in-java
	
	//What all of this does is simply add rounded edges to the JTextField
	
	 private Shape shape;
	   public RoundedJPasswordField(int size) {
	   super(size);
	   setOpaque(false);
	}
	protected void paintComponent(Graphics g) {
	   g.setColor(getBackground());
	   g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	   super.paintComponent(g);
	}
	protected void paintBorder(Graphics g) {
	   g.setColor(getForeground());
	   g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	}
	public boolean contains(int x, int y) {
	   if (shape == null || !shape.getBounds().equals(getBounds())) {
	      shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	   }
	   return shape.contains(x, y);
	   }

}
