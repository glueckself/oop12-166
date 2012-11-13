/**
 * fixed ratio [invariant]
 */
class DarkBox implements Pict {
    private double height;
    private double width;
    private char content;

    /**
     * @param height > 0 [precondition]
     * @param width > 0 [precondition]
     * @param content != space [precondition]
     */
    public DarkBox(double height, double width, char content) {
	this.height = height;
	this.width = width;
	this.content = content;
    }

    /**
     * this.content is set to content [postcondition]
     * @param content != space [precondition]
     */
    public void setContent(char content) {
	this.content = content;
    }

    /**
     * height = height * factor and width = width * factor [postcondition]
     */
    public void scale(double factor) {
	this.height = this.height * factor;
	this.width = this.width * factor;
    }

    /**
     * picture uses only characters provided in constructor [postcondition]
     * @return drawn height = ceiling height & drawn width = ceiling width [postcondition]
     */
    public String toString() {
	return null;	
    }
}
