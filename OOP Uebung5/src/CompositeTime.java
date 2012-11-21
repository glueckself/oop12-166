import java.util.Iterator;

/**
 * CompositeTime
 *
 * @author Julian Grosshauser
 */
class CompositeTime implements ElapsedTime {
    private Double[] data;

    /**
     * Set data array
     *
     * @param data data array to set.
     */
    public CompositeTime(Double[] data) {
	this.data = data;
    }

    /**
     * Use this value in shorter.
     * 
     * @return double Value to use in shorter.
     */
    public double shorterValue() {
	double sum = 0;

	if(this.data[0] == null) {
	    return sum;
	}

	for(int i = 0; i < this.data.length; i++) {
	    sum += this.data[i];
	}

	return sum;
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
