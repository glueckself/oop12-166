import java.util.Iterator;

class OrderedSet<T extends Shorter<? super T>> extends Set<T> implements Iterable<T> {
    /**
     * Sorted insert element into list.
     * Insert only if there is not already the same element in the list.
     * (Same element: test with == (identity check), instead of equals)
     *
     * @param elem Element to insert.
     */
    public void insert(T elem) {
	Iterator<T> iterator = this.iterator();
	Node current = head;

	while(iterator.hasNext()) {
	    if(iterator.next() == elem) {
		return;
	    }
	}
	
	if(head == null) {
	    this.tail = this.head = new Node(elem);
	} else {
	    //find insert position
	    while(current.elem.shorter(elem)) {
		current = current.next;

		//reached end of list
		if(current == null) {
		    break;
		}
	    }

	    //insert as last node
	    if(current == null) {
		this.tail.next = new Node(elem);
		this.tail.next.prev = this.tail;
		this.tail = this.tail.next;
	    //insert as first element
	    } else if(current == head) {
		this.head.prev = new Node(elem);
		this.head.prev.next = this.head;
		this.head = this.head.prev;
	    //insert somewhere in the middle
	    } else {
		current.prev.next = new Node(elem);
		current.prev.next.prev = current.prev;
		current.prev.next.next = current;
		current.prev = current.prev.next;
	    }
	}
    }
}
