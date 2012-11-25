import java.util.Iterator;

class List<T extends Android> implements Iterable<T> {
    private class Node {
	private T android;
	private Node next;

	private Node(T android) {
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
    public String insert(T android) {
	Iterator<T> iterator = this.iterator();

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

	if(android.software == null) {
	    return "Software not allowed";
	}

	/*
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
     * Get information about the android with the specified serialnumber.
     *
     * @param serialnumber Search for android with this serialnumber.
     * @return String A String containing information about the found android,
     * null otherwise.
     */
    public String find(int serialnumber) {
	String information = null;
	Iterator<T> iterator = this.iterator();

	if(iterator.hasNext()) {
	    T android = iterator.next();

	    //TODO: is this comparison allowed?
	    if(android.serialnumber == serialnumber) {
		//information = 
	    }
	}

	return information;
    }

    /**
     * Iterates over list.
     */
    private class ListIterator implements Iterator<T> {
	//current Android
	private Node current = List.this.head;

	/**
	 * Check if there is a next Android.
	 *
	 * @return boolean True if there is a next Android, false otherwise.
	 */
	public boolean hasNext() {
	    return this.current != null;
	}

	/**
	 * Get next Android.
	 * Sets current Android accordingly.
	 *
	 * @return Android Next Android.
	 */
	public T next() {
	    if(this.current == null) {
		return null;
	    }

	    T android = this.current.android;
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
    public Iterator<T> iterator() {
	return new ListIterator();
    }
}
