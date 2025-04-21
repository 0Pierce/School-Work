package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import GUI.GameBoard;
import GUI.SurfaceGUI;


public class ScotlandYardController extends JFrame {
	
	
	public GameBoard frame;
	
	protected static boolean isExecuted;
	protected static boolean isExecuted2;
	protected static boolean isExecuted3;
	protected static boolean isExecuted4;


	//Starts the gameboard (Dont fully understand this tbh but it works!)
	public static void main(String[] args) {
		System.out.println("Controller");
		SurfaceGUI start = new SurfaceGUI();
		
		//int i = 0;
		start.executeOnce();
		//start.GUI(i);
		
	}
	
	

}
