package A1;

public class Node {
	
	int data;
	//Head
	Node next;
	//Trailer
	Node prev;
	
	//Constructor
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

}
