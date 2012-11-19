import java.util.Iterator;

/**
 * Simple set.
 *
 * @author Julian Grosshauser
 */
class Set<T> implements Iterable {
    private class Node {
	private T elem;
	private Node next;
	private Node prev;

	private Node(T elem) {
	    this.elem = elem;
	}
    }

    private Node head;
    private Node tail;

    /**
     * Insert element into list.
     * Insert only if there is not already the same element in the list.
     * (Same element: test with == (identity check), instead of equals)
     *
     * @param elem Element to insert.
     */
    public void insert(T elem) {
	Iterator<T> iterator = this.iterator();

	//check if element is already in set
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
     * Iterates over set.
     */
    private class SetIterator implements Iterator<T> {
	//current element
	private Node p = head;

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
	 * @return T Next Element.
	 */
	public T next() {
	    T elem = this.p.elem;
	    this.p = this.p.next;
	    return elem;
	}

	public void remove() {
	    //this.currentElem.getNext
	}
    }

    /**
     * Get iterator.
     *
     * @return Iterator<T> Iterator.
     */
    public Iterator<T> iterator() {
	return new SetIterator();
    }
}
