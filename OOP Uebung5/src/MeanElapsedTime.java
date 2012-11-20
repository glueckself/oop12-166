/**
 * MeanElapsedTime
 *
 * @author Julian Grosshauser
 */
class MeanElapsedTime implements ElapsedTime {
    private Set<Double> data;

    /**
     * Initialize data Set.
     */
    public MeanElapsedTime() {
	this.data = new Set<Double>();
    }

    public boolean shorter(MeanElapsedTime compareTo) {
	//TODO: can't access data in compareTo directly => ?
    }

    /**
     * Count entries in data Set.
     *
     * @return int Count of data.
     */
    public int count() {
	int count = 0;
	Iterator<Double> iterator = this.data.iterator();

	while(iterator.hasNext()) {
	    iterator.next();
	    count++;
	}

	return count;
    }

    /**
     * Add data entry.
     *
     * @param data data entry to insert.
     */
    public void insert(Double data) {
	this.data.insert(data);
    }

    /**
     * Find highest data entry.
     *
     * @return double Highest data entry.
     */
    public double max() {
	double max = 0;
	double data = 0;
	Iterator<Double> iterator = this.data.iterator();

	while(iterator.hasNext()) {
	    data = iterator.next(); 

	    if(data > max) {
		max = data;
	    }
	}

	return max;
    }
}
