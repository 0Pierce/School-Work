package A1;

public class DoublyLinkedList {

	
	Node header;
	Node trailer;
	
	
	
	//Constructor
	public DoublyLinkedList() {
		header = new Node(-1);
		trailer = new Node(-1);
		
		header.next=trailer;
		trailer.prev = header;
		
		
	}
	
	//Creates a new node
	public void addNode(int data) {
        // Add node
        Node newNode = new Node(data);
        Node lastNode = trailer.prev;

        
        //Shifting the existing node structure to the right
        //To accomidate the new node
        lastNode.next = newNode;
        newNode.prev = lastNode;
        newNode.next = trailer;
        trailer.prev = newNode;
    }
	
	//Merging the two doublyLinkedLists
	public void concatenate(DoublyLinkedList list2) {
		
		//Swapping the trailer and header for the two lists
		this.trailer.prev.next = list2.header.next;
		
		//Same as above but reversed
		list2.header.next.prev = this.trailer.prev;
		
		//Position the second list at the end of the first
		this.trailer = list2.trailer;
	}
	
	public void print() {
		Node current = header.next;
		while(current != trailer) {
			System.out.println(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}
	
}
