/**
 * fixed ratio [invariant]
 * text can not be changed [invariant]
 */
class FreeBox implements Pict {
    protected double height;
    protected double width;
    private int stringHeight;
    private int stringWidth;
    private String text;

    public FreeBox() {
	return;
    }

    /**
     * @param text length > 0 [precondition]
     */
    public FreeBox(String text) {
	this.text = text;
    }
    
    private void calcStringDimensions() {

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
