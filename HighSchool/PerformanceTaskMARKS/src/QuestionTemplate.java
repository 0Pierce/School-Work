//Name: Pierce
//Date: Dec 14
//Desc Template / Constructors / getters and setters / ToString


public class QuestionTemplate {
	private String text;
	private String answer;
	//Set to boolean so can easily verify if it has been used
	private boolean Used;

	public QuestionTemplate(String text, String answer, boolean used) {
		super();
		this.text = text;
		this.answer = answer;
		this.Used = used;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean getUsed() {
		return Used;
	}

	public void setUsed(boolean used) {
		Used = used;
	}

	@Override
	public String toString() {
		return "QuizApplication [text=" + text + ", answer=" + answer + ", Used=" + Used + "]";
	}

}



