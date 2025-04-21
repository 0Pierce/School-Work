package controller;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Node {
	private static boolean Executed = false;
	private int nodeX;
	private int nodeY;
	public Point point = new Point();
	public Point pointX = new Point();
	public static String[][] neighbors = new String[202][202];
	//make an arraylist called nodes(not doing this anymore because you can access
	//the things from text file every time)
	
			//inside nodes we have to manage everthing that is about nodes
			//such as having a space taken or returning their method of transportation
			//(helps the ai decide where to make a move or additional GUI things)
			
		//make nodes off of the txt file
		
		
			//position.txt
			//first colomn is the actual places (marked by numbers) that the piece can travel to
			//second colomn stores their X position
			//third colomn stores their y posistion
	//requires for you to grab some things from the txt file
	public static int getNodeX(int num) throws FileNotFoundException {
		String[] split = getCordinates(num).split(" ");
	    for (String s : split) {
	        System.out.println(Integer.valueOf(s));
	    }
		return Integer.parseInt(split[1]);
	}

	public void setNodeX( int xValue) {
		this.nodeX = xValue;
	}

	public static int getNodeY(int num) throws FileNotFoundException {
		String[] split = getCordinates(num).split(" ");
	    for (String s : split) {
	        System.out.println(Integer.valueOf(s));
	    }
		return Integer.parseInt(split[2]);
	}

	public void setNodeY( int yValue) {
		this.nodeY = yValue;
	}
	private static String getCordinates(int num) throws FileNotFoundException {
	String number = Integer.toString(num);
	File Position = new File("text files/Scotland Yard - Positions.txt");
	try (Scanner scanner = new Scanner(Position)) {
		while (scanner.hasNextLine()) {
			String data = scanner.nextLine();
		    if(data.substring(0, data.indexOf(" ")).matches(number)) 
		    	return data;	
			}
	}
	return null;
	}
	
	
	//make the current node understand it's connections and that also identify the
	//method of transportation from a text file
		//(reminder that it has to check for both rows)
		//route.txt 
		//first colomn is the first one we are checking for the instanceof the number that 
		//we are standing on
		//second colomn wraps up the other possibile moves for
		//last colomn reports back what method of transportation we are using
		
	public static String[][] checkCloseBy(int nodeNum, int nextNodeNum) throws FileNotFoundException {
		//acesses the file
		File routes = new File("text files/Scotland Yard - Routes.txt");
		//catches the errors and makes sure the program doesn't crash
			
	    try (Scanner scanner = new Scanner(routes)) {
	    	//this takes it line by line and breaks it down
			while (scanner.hasNextLine()) {
				//breaks the txt file into 3 vairables 
				String[] data = scanner.nextLine().split(" ");
				//if the node num is int the first colomn it executes this and returns the close by node
				//if its not a the mentioned node
				//if it is the mentioned node it sendes it into a special message for the program to
				//find it more easliy
			    if (Integer.parseInt(data[0])==nodeNum) {
			    	if(Integer.parseInt(data[1])==nextNodeNum) {
			    		if(neighbors[nodeNum][nextNodeNum]!=null) {
			    			if(neighbors[nodeNum][nextNodeNum].charAt(0) != data[2].charAt(0))
			    				neighbors[nodeNum][nextNodeNum]= "multi";
			    		}
			    		else
			    			neighbors[nodeNum][nextNodeNum]= data[2];
			    	}
			    	else
			    		if(Integer.parseInt(data[1])==nextNodeNum) {
				    		if(neighbors[nodeNum][nextNodeNum]!=null) {
				    			if(neighbors[nodeNum][nextNodeNum].charAt(0) != data[2].charAt(0))
				    				neighbors[nodeNum][Integer.parseInt(data[0])]= "multi";
				    		}
				    		else
					    		neighbors[nodeNum][Integer.parseInt(data[0])]=data[2];
			    		}
			    }
			    //this is the last one but the node you are currently checking is on the secodnd column instead
			    else if (Integer.parseInt(data[1])==nodeNum) {
			    	if(Integer.parseInt(data[0])==nodeNum) {
			    		if(neighbors[nodeNum][nextNodeNum]!=null) {
			    			if(neighbors[nodeNum][nextNodeNum].charAt(0) != data[2].charAt(0))
				    			neighbors[nodeNum][nextNodeNum]= "multi";
			    		}
			    		else
			    			neighbors[nodeNum][nextNodeNum]= data[2];
			    		
					    
			    	}
			    	else
			    		neighbors[nodeNum][Integer.parseInt(data[0])]=data[2];
			    }
			}
		}
	    //this sends the special message if it is the nieghbors to the mentioned nodes
	    if (neighbors[nodeNum][nextNodeNum]!= null) {
	    	neighbors[201][201]= "True";
	    	return neighbors;
	    }
	    //returns the finnished array
		return neighbors;
		
	}
	//use this to move the things 
	public void moveToNextPoint(int nextNode) {
		//moves the point to the next point 
		try {
			
			point.translate(getNodeX(nextNode), getNodeY(nextNode));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void moveToNextPointX(int nextNode) {
		//moves the point to the next point 
		try {
			
			pointX.translate(getNodeX(nextNode), getNodeY(nextNode));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isExecuted() {
		return Executed;
	}

	public static void setExecuted(boolean executed) {
		Executed = executed;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Point getPointX() {
		return pointX;
	}

	public void setPointX(Point pointX) {
		this.pointX = pointX;
	}

	public static String[][] getNeighbors() {
		return neighbors;
	}

	public static void setNeighbors(String[][] neighbors) {
		Node.neighbors = neighbors;
	}

	public int getNodeX() {
		return nodeX;
	}

	public int getNodeY() {
		return nodeY;
	}
	
	
}
