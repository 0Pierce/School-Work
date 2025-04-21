package fractals;

import java.awt.*;

import javax.swing.*;

//Sort of like the paper/canvas
public class FractalPanel extends JPanel {
	
	//
	private Color color;
	
	//
	private int level;
	
	//
	public FractalPanel(int currentLevel) {
		
		//
		color = Color.BLUE;
		level = currentLevel;
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(800,600));
		
		
		
		
	}
	
	public void drawDragonCurveFractal(int level, int x1, int y1, int x2, int y2, Graphics g) {
		
		//base case
		if(level == 0) {
			
			//Draws a line
			g.drawLine(x1, y1, x2, y2);;
		}
		//Recursive step
		else {
			
			//The second part is in case it goes over
			int xn = (x1 + y1) /2 + (y2 - y1) /2;
			int yn = (y1 + y2) /2 - (x2 - x1) /2;
			
			//Draws it
			drawDragonCurveFractal(level -1, x1, y1, xn, yn, g);
			drawDragonCurveFractal(level -1, x2, y2, xn, yn, g);
			
		}
			
	
		
			
		
		
	}
	
	
	

	//
	public void setLevel(int i) {
		// TODO Auto-generated method stub
		
		level = currentLevel;
		
	}

	//Missing method
	
	
	
	//
	public void setColor(Color color) {
		
		this.color = color;
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(color);
		
		if(FractalFrame.fractalType.equals("Dragon Curve")) {
			
			drawDragonCurveFractal(level, 600, 200 ,100 , 200, g);
			
			
			
			
		}
		
	}

}
