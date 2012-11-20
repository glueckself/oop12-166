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

    public boolean shorter(CompositeTime compareTo) {
	//TODO: Sama as MeanElapsedTime
    }

    /**
     * Get length of data array.
     *
     * @return int Length of data array
     */
    public int count() {
	return this.data.length();
    }

    /**
     * Find lowest data entry.
     *
     * @return double Lowest data entry
     */
    public double min() {
	double min = 0;

	for(int i = 0; i < this.data.length(); i++) {
	    if(this.data[i] < min) {
		min = this.data[i];
	    }
	}

	return min;
    }
}
