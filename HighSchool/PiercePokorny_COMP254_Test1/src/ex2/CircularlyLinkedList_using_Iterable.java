/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ex2;
import java.util.Iterator;


/**
 * An implementation of a circularly linked list.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

//Here, the original CircularlyLinkedList code has been modified
//by Dr. Arindam Das to show the use of Iterable and Iterator
//interface, and the use of special for-loop:
//
//for(Type t : pointer-to-relevant-container) {
//    statement-1;
//    ....
//    statement-n;
//}

//When a class implements Iterable interface, an object of 
//the class can be the target of "special for" loop
//(often called "for-each" loop)
//We show the use of Iterable to traverse nodes of the CircularlyLinkedList
//For this purpose, we need to modify the class CircularlyLinkedList
//(You should look and compare the original class from Lesson3Examples.zip file
//provided in comp254 course shell)
public class CircularlyLinkedList_using_Iterable<E> implements Iterable<E> //This line is changed from original
{
  //---------------- nested Node class ----------------
  /**
   * Singly linked node, which stores a reference to its element and
   * to the subsequent node in the list.
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;     // an element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;  // a reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------

  // instance variables of the CircularlyLinkedList
  /** The designated cursor of the list */
  private Node<E> tail = null;                  // we store tail (but not head)

  /** Number of nodes in the list */
  private int size = 0;                         // number of nodes in the list

  /** Constructs an initially empty list. */
  public CircularlyLinkedList_using_Iterable() { }             // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  //Get max


  public void reverseList() {
	  
	    if (isEmpty()) {
	    	System.out.println("Linked List Empty");
	    }else {
	    	 Node<E> current = tail.getNext(); // Start from the head
	 	    Node<E> prev = null;
	 	    Node<E> next;

	 	    // Traverse the list and reverse the links
	 	    while (current != null) {
	 	        next = current.getNext(); 
	 	        current.setNext(prev); 
	 	        prev = current; 
	 	        current = next; 
	 	    }

	 	    // Switch heads
	 	    tail = prev;
	    	
	    }

	   
	  
  }
  
  
  
  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() {             // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return tail.getNext().getElement();         // the head is *after* the tail
  }

  /**
   * Returns (but does not remove) the last element of the list
   * @return element at the back of the list (or null if empty)
   */
  public E last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Rotate the first element to the back of the list.
   */
  public void rotate() {         // rotate the first element to the back of the list
    if (tail != null)                // if empty, do nothing
      tail = tail.getNext();         // the old head becomes the new tail
  }

  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
    if (size == 0) {
      tail = new Node<>(e, null);
      tail.setNext(tail);                     // link to itself circularly
    } else {
      Node<E> newest = new Node<>(e, tail.getNext());
      tail.setNext(newest);
    }
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) { // adds element e to the end of the list
    addFirst(e);             // insert new element at front of list
    tail = tail.getNext();   // now new element becomes the tail
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null;              // nothing to remove
    Node<E> head = tail.getNext();
    if (head == tail) tail = null;           // must be the only node left
    else tail.setNext(head.getNext());       // removes "head" from the list
    size--;
    return head.getElement();
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    if (tail == null) return "()";
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = tail;
    do {
      walk = walk.getNext();
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
    } while (walk != tail);
    sb.append(")");
    return sb.toString();
  }
  
  //Change to the class begins
  public Iterator<E> iterator() { 
		return new ElementIterator(this); 
  } 
  
 
  private class ElementIterator implements Iterator<E> { 
		
		private CircularlyLinkedList_using_Iterable<E> cLL;
		private int cursor;
		private Node<E> cursorPointer;
		
		public ElementIterator(CircularlyLinkedList_using_Iterable<E> m) {
			 cLL = m;
		     cursor = 0;
		     cursorPointer = cLL.tail;
		}
		
		// Checks if next element exists 
		public boolean hasNext() { 
		    return ( cursor < cLL.size() );
		} 
		
		public E next() { 
		    cursor = cursor + 1;
		    cursorPointer = cursorPointer.getNext();
		    return cursorPointer.getElement();
		} 
		
  } 
//Change to the class ends
  
  
  
//main method
  public static void main(String[] args)
  {
	  
	  //(LAX, MSP, ATL, BOS)
	  CircularlyLinkedList_using_Iterable<String> circularList = new CircularlyLinkedList_using_Iterable<String>();
	  circularList.addFirst("LAX");
	  circularList.addLast("MSP");
	  circularList.addLast("ATL");
	  circularList.addLast("BOS");
	  //
	  
	  //example loop directly using "hasNext()"
	  Iterator<String> it = circularList.iterator();
	  while(it.hasNext()) {
		  System.out.println(it.next());
	  }
	  System.out.println();
		
	  //example loop using "special for" (often called "for-each" loop)
      for(String s : circularList) {
          System.out.println(s);
      }
      
      
      
      
      circularList.reverseList();
     System.out.println();
      System.out.println("Reversed List:");
      for (String s : circularList) {
          System.out.println(s);
      }

      
  }
}
