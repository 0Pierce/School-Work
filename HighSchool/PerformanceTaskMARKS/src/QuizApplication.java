import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//Name: Pierce
//Date: Dec 14
//Desc Application, gives the user a quiz

public class QuizApplication {

	public static void main(String[] args) {
		
		//Array
		QuestionTemplate[] quizArray = new QuestionTemplate[5];

		// Methods
		quizArray = fillBank(quizArray);
		showIntro();
		double amount = getAmount();
		runQuiz(amount, quizArray);
		
		

	}

	private static QuestionTemplate[] fillBank(QuestionTemplate[] quizArray) {
		String answer1 = "Main";
		String answer2 = "Methods";
		String answer3 = "Class";
		String answer4 = "Array";
		String answer5 = "Instance";
		// Hard coding of the array   /Settings booleans to false so you can know which were already used
		quizArray[0] = new QuestionTemplate("What is the name of the method to run a Java program?", answer1, false);
		quizArray[1] = new QuestionTemplate("What are subprograms in Java called?", answer2, false);
		quizArray[2] = new QuestionTemplate("What is a template used to make objects in Java?", answer3, false);
		quizArray[3] = new QuestionTemplate("What is another name for a list in Java?", answer4, false);
		quizArray[4] = new QuestionTemplate("What is a particular object known as?", answer5, false);

		return quizArray;

	}

//The intro
	private static void showIntro() {
		System.out.println("JAVA QUIZ");
		System.out.println("=========");
		System.out.println("Type your answer and press <ENTER>");
		System.out.println("At the end you will be given your score");

	}

	//Obtaining the user input
	private static int getAmount() {

		Scanner input = new Scanner(System.in);
		boolean uwu = false;

		int amount = 0;
		
		// Error checking the user entry to make sure he enters the desired input
		while (true) {
			System.out.println(" How many questions do you want? (max 5)");
			amount = input.nextInt();

			if (amount > 0 && amount < 6) {

				return amount;

			} else
				System.out.println("That aint it chief");

		}

	}

	// Runs the actual quiz
	private static void runQuiz(double amount, QuestionTemplate[] quizArray) {
		Scanner input = new Scanner(System.in);
		double count = 0;
		//Decimal Variable
		double deci;
		//Percentage Variable
		double perce;

		boolean random = false;

		// For loop to run this code the amount of times the user specified
		for (int i = 0; i < amount; i++) {

			// Random boolean name/loop to just make sure the questions are done randomly
			while (random == false) {

				//Creates a random number within the loop
				Random num = new Random();
				int int_random = num.nextInt((int) amount);
				
				//Checks answer
				if (quizArray[int_random].getUsed() == false) {
                                               //Problem is here somewhere                
					System.out.println(quizArray[(int) amount].getText());
					String answer = input.next();

					if (answer.equalsIgnoreCase(quizArray[int_random].getAnswer())) {
						count++;

					}

					quizArray[int_random].setUsed(true);
					random = true;

				}

			}

			random = false;

		}

		// A little bit of processing to convert the score into %
		deci = count / amount;
		perce = deci * 100;

		
		System.out.printf("Your score is %.2f %%", perce);

	}

}
