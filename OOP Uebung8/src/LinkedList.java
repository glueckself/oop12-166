/**
 * Simple set.
 *
 * @author Julian Grosshauser
 */
class LinkedList {
    private class Node {
	private Object elem;
	private Node next;
	private Node prev;

	private Node(Object elem) {
	    this.elem = elem;
	}
    }

    private Node head;
    private Node tail;

    /**
     * Insert element into list.
     *
     * @param elem Element to insert.
     */
    public void insert(Object elem) {
	LinkedListIterator iterator = this.iterator();

	while(iterator.hasNext()) {
	    if(iterator.next() == elem) {
		return;
	    }
	}

	if(head == null) {
	    this.tail = this.head = new Node(elem);
	} else {
	    tail.next = new Node(elem);
	    tail.next.prev = tail;
	    tail = tail.next;
	}
    }

    /**
     * Iterates over linked list.
     */
    public class LinkedListIterator {
	//current element
	private Node p = LinkedList.this.head;;

	/**
	 * Check if there is a next Element.
	 *
	 * @return boolean True if there is a next element, false otherwise.
	 */
	public boolean hasNext() {
	    return p != null;
	}

	/**
	 * Get next Element.
	 * Sets current Element accordingly.
	 *
	 * @return Object Next Element.
	 */
	public Object next() {
	    if(this.p == null) {
		return null;
	    }

	    Object elem = this.p.elem;
	    this.p = this.p.next;
	    return elem;
	}

	public void remove() {
	    Node elem;

	    if(this.p == null) {
	      return;
	    }

	    if(this.p.prev == null) {
	      //remove first element
	      LinkedList.this.head=this.p.next;
	      if(LinkedList.this.head != null) {
		LinkedList.this.head.prev = null;
	      }
	      this.p = LinkedList.this.head;
	    } else {
	      //remove element somewhere in the list
	      elem = this.p.prev;
	      elem.next = this.p.next;
	      if(elem.next != null) {
		this.p.next.prev=elem;
	      } else {
		LinkedList.this.tail = elem;
	      }

	      this.p=elem.next;
	    }
	}
    }

    /**
     * Get iterator.
     *
     * @return LinkedListIterator Iterator.
     */
    public LinkedListIterator iterator() {
	return new LinkedListIterator();
    }
}
