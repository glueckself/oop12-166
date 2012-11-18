import java.util.Iterator;

/**
 * A simple set.
 *
 * @author Julian Grosshauser
 */

class Set<T> implements Iterable {
    private List<T> list;

    /**
     * Constructor.
     * Create new List.
     */
    public Set() {
	this.list = new List<T>();	
    }

    /**
     * Insert element into list.
     * Insert only if there is not already a similar element in the list.
     *
     * @param elem Element to insert.
     */
    public void insert(T elem) {
		
    }

    /**
     * Iterates over linked list.
     */
    private class SetIterator<E extends List<T>> implements Iterator {
	private E currentElem;

	public SetIterator() {
	    this.currentElem = list;
	}

	public boolean hasNext() {
	    if(this.currentElem.getNextElem() != null) {
		return true;
	    }

	    return false;
	}

	public T next() {
	    this.currentElem = this.currentElem.getNextElem();
	    return this.currentElem;
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
    public SetIterator<List<T>> iterator() {
	return this.new SetIterator<List<T>>();
    }
}
