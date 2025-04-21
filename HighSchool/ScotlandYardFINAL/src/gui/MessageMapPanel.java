package gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

//Author: Aarib

public class MessageMapPanel {
	
	//tried for hours and couldn't get working, so copy and pasted this code:
	//https://www.tutorialspoint.com/how-to-implement-propertychangelistener-using-lambda-expression-in-java#:~:text=A%20PropertyChangeListener%20is%20a%20functional,the%20property%20that%20has%20changed. 
	private final PropertyChangeSupport change = new PropertyChangeSupport(this);
	private int value;
	private int[] valueB = new int[200];
	
	// constructor method
	public MessageMapPanel() {
		System.out.println("go");
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//				UTILITY MEHTODS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	//creates the listener
	public void addPropertyChangeListener(PropertyChangeListener listener) {
	   change.addPropertyChangeListener(listener);
	}
	
	//removes the listener
	public void removePropertyChangeListener(PropertyChangeListener listener) {
	   change.removePropertyChangeListener(listener);
	}
	
	//gets the stored value in this class
	public int getValue() {
	   return value;
	}
	
	//sets the new value and activates the listener
	public void setValue(int newValue) {
	  int oldValue = value;
	  value = newValue;
	  change.firePropertyChange("value", oldValue, newValue);
	  System.out.println(value);
	}

	
	//getters and setters
	public void setValueB(int location, int i) {
		this.valueB[i] = location;
		
	}	
	
	public int[] getValueB() {
		   return valueB;
		}
}
