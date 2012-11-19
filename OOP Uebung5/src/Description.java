/**
 * Description.
 *
 * @author Julian Grosshauser
 */
class Description implements Shorter<Description> {
    private String description;

    /**
     * Set description.
     *
     * @param description Set this description.
     */
    public Description(String description) {
	this.description = description;
    }

    /**
     * Get description.
     *
     * @return String Description.
     */
    public String toString() {
	return this.description;
    }

    /**
     * Compares Description length in argument to this instance's description
     * length.
     *
     * @param compareTo Description object to compare to.
     * @return boolean True if this instance's description is shorter than the
     * description of the argument.
     */
    public boolean shorter(Description compareTo) {
	if(this.description.length() < compareTo.toString().length()) {
	    return true;
	}

	return false;
    }

    /**
     * Count lines in description.
     *
     * @return int Line count.
     */
    public int lines() {
	int i = -1; 
	int counter = 1;

	while((i = this.description.indexOf('\n', i + 1)) != -1) {
	    //don't count line if linebreak is last char of String
	    if(i != this.description.length() - 1) {
		counter++;
	    }
	}

	return counter;
    }
}
