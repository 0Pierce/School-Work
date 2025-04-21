package A1;

public class main {
	
	public static void main(String[] args) {
		
		
		//Create the lists
		DoublyLinkedList firstList = new DoublyLinkedList();
        DoublyLinkedList secondList = new DoublyLinkedList();
		
        
		//Adding numbers to the list
        for (int i = 1; i <= 5; i++) {
            firstList.addNode(i);
        }

        // Add nodes to the second list
        for (int i = 6; i <= 10; i++) {
            secondList.addNode(i);
        }
        
        //Displaying all the lists
        System.out.println("First List:");
        firstList.print();

        System.out.println("Second List:");
        secondList.print();

        // Concatenate the second list to the first list
        firstList.concatenate(secondList);

        System.out.println("Merged List:");
        firstList.print();
        
	}

}
