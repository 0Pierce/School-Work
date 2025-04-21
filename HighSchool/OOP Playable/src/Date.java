

import java.util.Arrays;

public class Date{

	// Fields
	private int month;
	private int day;
	private int year;

	String[] ArrayOfMonths = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };

	int ArrayOfDays[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// Constructors
	
	
	
	// First case
	public Date(int month, int day, int year) {

		this.month = month;
		this.day = day;
		this.year = year;

	}

	

	// Second case
	public boolean Date(String month, int day, int year) {

		//
		for (int i = 0; i < ArrayOfMonths.length; i++) {
			if (month.equals( ArrayOfMonths[i + 1])) {

				return true;

			}

		}
		return false;

	}

	//Third case
	public Date(int day, int year) {
	//Not too sure here
		
		boolean leapYear = false;
		
		
		if(year % 4 == 0) {
			
			leapYear = true;
			
			if(year % 100 == 0 && !(year % 400 == 0)) {
				leapYear = false;
			}
		}
		
		
		if(leapYear)
			ArrayOfDays[1] = 29;
		
		for(int i = 0; i < ArrayOfDays.length; i++) {
			
			if(day - ArrayOfDays[i] <= 0) {
				
				this.day = day;
				month = i +1;
				break;
				
			}else {
				day -=ArrayOfDays[i];
			}
		}
		
		
		this.year = year;
		

	}
	
	//Getters and Setters

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String[] getArrayOfMonths() {
		return ArrayOfMonths;
	}

	public void setArrayOfMonths(String[] arrayOfMonths) {
		ArrayOfMonths = arrayOfMonths;
	}

	public int[] getArrayOfDays() {
		return ArrayOfDays;
	}

	public void setArrayOfDays(int[] arrayOfDays) {
		ArrayOfDays = arrayOfDays;
	}
	
	
	
	
	
	
	//Output
	@Override
	public String toString() {
		return "Date [month=" + month + ", day=" + day + ", year=" + year + ", ArrayOfMonths="
				+ Arrays.toString(ArrayOfMonths) + ", ArrayOfDays=" + Arrays.toString(ArrayOfDays) + "]";
	}

	private int getDayNumber() {
		
		int dayNum = 0;
		
		for(int m = 0; m < (month -1); m++) {
			dayNum += ArrayOfDays[m];
		}
		
		dayNum += day;
		return dayNum;
			
	}
	

}
