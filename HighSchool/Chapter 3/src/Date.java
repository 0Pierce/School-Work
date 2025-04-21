
public class Date {
	
	private int month;
	private int day;
	private int Year;
	
	public Date() {
		
	}
	
	
	public Date(int month, int day, int Year) {
		
		setMonth(month);
		setDay(day);
		setYear(Year);
		
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		
		if (month >= 1 && month <= 12)
			this.month = month;
		else
			this.month = 1;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		
		if (day < 1|| ((month ==4 || month == 6 || month ==9 || month == 11) && day > 30) ||(month == 2 && day>28||day>31))
			this.day = 1;
		else
			this.day = day;
	}
	
	public int getYear() {
		return Year;
	}
	
	public void setYear(int Year) {
		
		if (Year >= 1970 && Year <= 2020)
			this.Year=Year;
		else
			this.Year = 1970;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Date [month=" + month + ", day=" + day + ", Year=" + Year + "]";
	}
	
	public String displayDate() {
		
		return String.format("%d/%d/%d", month, day, Year);
	}

}
