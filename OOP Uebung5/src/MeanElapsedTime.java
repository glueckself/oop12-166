import java.util.Iterator;

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

    /**
     * Use this value in shorter.
     * 
     * @return double Value to use in shorter.
     */
    public double shorterValue() {
	double content = 0;
	Iterator<Double> iterator = this.data.iterator();

	while(iterator.hasNext()) {
	    content += iterator.next();
	}

	return content / this.count();
    }

    /**
     * Compare this object to the argument.
     *
     * @param compareTo Compare to this object.
     * @return boolean True if this object is shorter than compareTo. Otherwise false.
     */
    public boolean shorter(ElapsedTime compareTo) {
	if(this.shorterValue() < compareTo.shorterValue()) {
	    return true;
	}

	return false;
    }

    */

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
