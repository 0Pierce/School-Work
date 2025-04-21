import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class LibraryApplication {
	
	static Book[] bookList = new Book[5];
	private static Scanner input = new Scanner(System.in);
	private static final int EXIT = 0;
	
	
	
	public static void main(String[] args) {
		
		int choice = 0;
		
		System.out.println("My book library");
		
		filllibrary();
		
		do {
		
		
		
		if (choice ==1)
			showLibrary();
		else if (choice ==2) {
			System.out.println("Enter a word from the book title: ");
			showBook(input.next());
		}else if (choice == 3)
			showLibraryByTitle();
		else if (choice ==4)
			showLibraryBuCost();
		else if (choice ==5)
			break;
		}while (choice != EXIT);
		
		
		
		
		
		
		
	}
	
	private static void fillLibrary() {
		// TODO Auto-generated method stub
		
		bookList[0] = new Book("In search of lost time volume I swann's way","Marcel proust", 656,1998,"9780375751540",21.60);
		bookList[1] = new Book("Don quixote","Miguel de Cervantes Saavendra",1072,1998,"9780142437230",15.00);
	}

	private static int showMenu() {
		// TODO Auto-generated method stub
		
		int choice;
		Scanner input = new Scanner (System.in);
		
		System.out.println("1)Show the library");
		System.out.println("2)Show book");
		System.out.println("3(Show library by title");
		System.out.println("4(Show library by cost");
		System.out.println("5) Exit");
		
		
		choice = input.nextInt();
		
		clearConsole();
		
		return choice;
	}

	private static void showLibrary() {
		
		System.out.println("My book Library");
		
		for(int index = 0;index<bookList.length;index++);{
			
			if(bookList[index].getIsbn().equals("00000000"))
				System.out.println("Invalid ISBN");
				else
					System.out.println(bookList[index]);
		}
		
		
	}

	private static void showLibraryByTitle() {
		// TODO Auto-generated method stub
		
		Arrays.sort(bookList,Comparator.comparing(Book::getTitle));
		System.out.println("\n(Sorted by Title)");
		showLibrary();
		
	}

	private static void showLibraryByCost() {
		// TODO Auto-generated method stub
		Arrays.sort(bookList, Comparator.comparing(Book::getCost));
		System.out.println("\n(Sorted by Cost)");
		showLibrary();
		
	}

	private static void clearConsole(String key) {
		
		for(int index = 0; index<bookList.length;index++)
			if(bookList[index].getTitle().contains(key))
				System.out.println(bookList[index]);
		
		
		
		private static void clearConsole() {
			for(int row = 0;row <=50;row++)
				System.out.println();
		}
		
	}

}
