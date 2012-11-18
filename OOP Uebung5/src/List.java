/**
 * A simple linked list.
 *
 * @author Julian Grosshauser
 */

class List<T> {
    private T elem;
    private List<T> nextElem;

    /**
     * Empty constructor.
     */
    public List() {
	return;
    }

    /**
     * Set element.
     * 
     * @param elem Element to set.
     */
    public void setElem(T elem) {
	this.elem = elem;
    }

    /**
     * Get element.
     *
     * @return T Element.
     */
    public T getElem() {
	return this.elem;
    }

    /**
     * Set next element.
     *
     * @param elem Element to set.
     */
    public void setNextElem(List<T> elem) {
	this.nextElem = elem;
    }

    /**
     * Get next element.
     *
     * @return List<T> Element.
     */
    public List<T> getNextElem() {
	return this.nextElem;
    }
}
