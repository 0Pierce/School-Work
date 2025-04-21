
public class Gradebook {
	
	private String courseName;
	private String instructorName;
	public Gradebook(String courseName, String instructorName) {
		super();
		this.courseName = courseName;
		this.instructorName = instructorName;
	}
	
	public void setCourseName(String course) {
		courseName = course;
	}
	public String getCourseName() {
		return courseName;
	}
	
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
	public String getInstructorName() {
		return instructorName;
	}
	@Override
	public String toString() {
		return "Gradebook [courseName=" + courseName + ", instructorName=" + instructorName + "]";
	}
	
	public void displayMessage() {
		System.out.printf("Welcome to the grade book for \n%s\n ", courseName);
		System.out.printf("This course is presented by: %s\n", getInstructorName());
	}

}
