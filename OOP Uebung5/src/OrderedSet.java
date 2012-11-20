import java.util.Iterator;

class OrderedSet<T extends Shorter<T>> extends Set<T> implements Iterable {

    private Node head;
    private Node tail;

    /**
     * Sorted insert element into list.
     * Insert only if there is not already the same element in the list.
     * (Same element: test with == (identity check), instead of equals)
     *
     * @param elem Element to insert.
     */
    public void insert(T elem) {
		Iterator<T> iterator = this.iterator();
	
		while(iterator.hasNext()) {
		    if(iterator.next() == elem) {
			return;
		    }
		}
		
		
		if(head == null) {
		    this.tail = this.head = new Node(elem);
		} else {

				}
			}
		}

	}
}
