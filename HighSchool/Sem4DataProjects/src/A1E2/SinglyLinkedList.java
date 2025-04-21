package A1E2;

public class SinglyLinkedList {
	
	Node head;
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
	
	//Adding the nodes to the list
	public void addNode(int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		
	}
	
	//Perform the node swapping
	public void swapNodes(int node1Index, int node2Index) {
		
		
		//Making sure the indexes arent the same
		//To avoid errors
		if(node1Index == node2Index) {
			return;
		}
		
		
		//Start the pointers for the first node, and get to the index of the first value
		//that needs to be swapped
		Node prev1 = null, current1 = head;
        for (int i = 1; i < node1Index && current1 != null; i++) {
            prev1 = current1;
            current1 = current1.next;
        }

        //Gets the pointer to the second value that needs to be swapped
        Node prev2 = null, current2 = head;
        for (int i = 1; i < node2Index && current2 != null; i++) {
            prev2 = current2;
            current2 = current2.next;
        }

        // Make sure the data isnt empty
        if (current1 == null || current2 == null) {
            System.out.println("Invalid indices. Nodes not found.");
            return;
        }

        // Swap the indexes
        if (prev1 != null) {
            prev1.next = current2;
        } else {
            head = current2;
        }

        if (prev2 != null) {
            prev2.next = current1;
        } else {
            head = current1;
        }

        //Temprarly store the node data while we are swapping it
        Node temp = current1.next;
        
        //Finalize the swap
        current1.next = current2.next;
        current2.next = temp;
	}
	
	
    public void print() {
        
    	Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
