import java.util.Iterator;

/**
 * CompositeTime
 *
 * @author Julian Grosshauser
 */
class CompositeTime implements ElapsedTime<CompositeTime> {
    private Double[] data;

    /**
     * Set data array
     *
     * @param data data array to set.
     */
    public CompositeTime(Double[] data) {
	this.data = data;
    }

    public boolean shorter(CompositeTime compareTo) {
	double sum = 0;
	double sumCompareTo = 0;

	for(int i = 0; i < this.data.length; i++) {
	    sum += this.data[i];
	}

	for(int i = 0; i < compareTo.data.length; i++) {
	    sumCompareTo += compareTo.data[i];
	}
	
	if(sum < sumCompareTo) {
	    return true;
	}

	return false;
    }

    /**
     * Get length of data array.
     *
     * @return int Length of data array
     */
    public int count() {
	return this.data.length;
    }

    /**
     * Find lowest data entry.
     *
     * @return double Lowest data entry
     */
    public double min() {
	double min = 0;

	for(int i = 0; i < this.data.length; i++) {
	    if(this.data[i] < min) {
		min = this.data[i];
	    }
	}

	return min;
    }
}
