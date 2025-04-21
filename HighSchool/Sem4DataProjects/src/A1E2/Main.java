package A1E2;

public class Main {
	
	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		  // Add nodes to the list
		//Adds data to the list
        for (int i = 1; i <= 5; i++) {
        	list.addNode(i);
        }

        System.out.println("Original List:");
        list.print();

        // Swap nodes at index 2 and 4
        list.swapNodes(2, 4);

        System.out.println("List after swapping nodes at index 2 and 4:");
        list.print();
		
	}

}
