import java.util.Iterator;

class OrderedSet<T extends Shorter<T>> extends Set<T> implements Iterable {
    /**
     * Sorted insert element into list.
     * Insert only if there is not already the same element in the list.
     * (Same element: test with == (identity check), instead of equals)
     *
     * @param elem Element to insert.
     */
    public void insert(T elem) {
	Iterator<T> iterator = this.iterator();
	Node current = tail;

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
		

=======
		//reached end of list
		if(current == null) {
		    break;
		}
	    }

	    if(current == null) {
		tail.next = new Node(elem);
		tail.next.prev = tail;
		tail = tail.next;
	    } else {
		current.prev.next = new Node(elem);
		current.prev.next.prev = current.prev;
		current.prev.next.next = current;
		current.prev = current.prev.next;
	    }
	}
    }
}
