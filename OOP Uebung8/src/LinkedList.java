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
	/*
	Iterator<T> iterator = this.iterator();

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

    /**
     * Iterates over linked list.
     */
    private class LinkedListIterator {
	//current element
	private Node p = Set.this.head;

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
	    if(this.p == null) {
		return null;
	    }

	    T elem = this.p.elem;
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
          Set.this.head=this.p.next;
          if(Set.this.head != null) {
            Set.this.head.prev = null;
          }
          this.p = Set.this.head;
        } else {
          //remove element somewhere in the list
          elem = this.p.prev;
          elem.next = this.p.next;
          if(elem.next != null) {
            this.p.next.prev=elem;
          } else {
            Set.this.tail = elem;
          }

          this.p=elem.next;
        }
	}
    }

    /**
     * Get iterator.
     *
     * @return Iterator Iterator.
     */
    public Iterator iterator() {
	return new LinkedListIterator();
    }
}
