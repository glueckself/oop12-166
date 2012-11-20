import java.util.Iterator;

/**
 * MeanElapsedTime
 *
 * @author Julian Grosshauser
 */
class MeanElapsedTime implements ElapsedTime<MeanElapsedTime> {
    private Set<Double> data;

    /**
     * Initialize data Set.
     */
    public MeanElapsedTime() {
	this.data = new Set<Double>();
    }

    /**
     * Compare average of data set to average of data set of compareTo
     *
     * @param compareTo Contains data set to compare to.
     * @return boolean True if average of this object is shorter than the
     * average of compareTo. Otherwise false.
     */
    public boolean shorter(MeanElapsedTime compareTo) {
	double content = 0;
	double average, averageCompareTo;
	Iterator<Double> iterator = this.data.iterator();

	while(iterator.hasNext()) {
	    content += iterator.next();
	}

	average = content / this.count();

	content = 0;
	iterator = compareTo.data.iterator();

	while(iterator.hasNext()) {
	    content += iterator.next();
	}
	
	averageCompareTo = content / compareTo.count();

	if(average < averageCompareTo) {
	    return true;
	}

	return false;
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
