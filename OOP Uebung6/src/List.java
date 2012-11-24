import java.util.Iterator;

class List implements Iterable {
    private class Node {
		private Android android;
		private Node next;
	
		private Node(Android android) {
		    this.android = android;
		}
    }

    private Node head;
    private Node tail;

    /**
     * Insert android into list.
     *
     * @param android Android to insert.
     * @return String null if insert was successfull, otherwise error code
     */
    public String insert(Android android) {
	Iterator iterator = this.iterator();

	//TODO: check if serialnumber is already in list
	/*
	while(iterator.hasNext()) {
	    if(iterator.next() == elem) {
		return;
	    }
	}
	*/

	if(android.skin == null) {
	    return "Skin not allowed";
	}

	/* not there yet
	if(android.software == null) {
	    return "Software not allowed";
	}

	if(android.actors == null) {
	    return "Actors not allowed";
	}
	*/

	if(head == null) {
	    this.tail = this.head = new Node(android);
	} else {
	    tail.next = new Node(android);
	    tail = tail.next;
	}

	return null;
    } 

    /**
     * Iterates over list.
     */
    private class ListIterator implements Iterator {
	//current Android
	private Node current = List.this.head;

	/**
	 * Check if there is a next Android.
	 *
	 * @return boolean True if there is a next Android, false otherwise.
	 */
	public boolean hasNext() {
	    return current != null;
	}

	/**
	 * Get next Android.
	 * Sets current Android accordingly.
	 *
	 * @return Android Next Android.
	 */
	public Android next() {
	    if(this.current == null) {
		return null;
	    }

	    Android android = this.current.android;
	    this.current = this.current.next;
	    return android;
	}

	//not implemented
	public void remove() {
	    return;
	}
    }

    /**
     * Get iterator.
     *
     * @return Iterator Iterator.
     */
    public Iterator iterator() {
	return new ListIterator();
    }
}
