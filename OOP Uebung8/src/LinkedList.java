@Member("Julian Großhauser")
class LinkedList {
    private class Node {
	private Object elem;
	private Node next;
	private Node prev;
	
	@Member("Julian Großhauser")
	private Node(Object elem) {
	    this.elem = elem;
	}
    }
    
    private Node head;
    private Node tail;

    @Member("Julian Großhauser")
    public void insert(Object elem) {
	/*
	LinkedListIterator iterator = this.iterator();

	while(iterator.hasNext()) {
	    if(iterator.next() == elem) {
		return;
	    }
	}
	*/

	if(head == null) {
	    this.tail = this.head = new Node(elem);
	} else {
	    tail.next = new Node(elem);
	    tail.next.prev = tail;
	    tail = tail.next;
	}
    }

    @Member("Julian Großhauser")
    public class LinkedListIterator {
	//current element
	private Node p = LinkedList.this.head;

	@Member("Julian Großhauser")
	public boolean hasNext() {
	    return p != null;
	}

	@Member("Julian Großhauser")
	public Object next() {
	    if(this.p == null) {
		return null;
	    }

	    Object elem = this.p.elem;
	    this.p = this.p.next;
	    return elem;
	}
	
	@Member("Julian Großhauser")
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

    @Member("Julian Großhauser")
    public LinkedListIterator iterator() {
	return new LinkedListIterator();
    }
}
