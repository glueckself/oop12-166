/**
 * fixed ratio [invariant]
 * border and content can not be changed [invariant]
 * '*' used as border, and ' ' used as content [invariant]
 */
class ClearBox extends Box implements Pict {
    /**
     * @param height > 0 [precondition]
     * @param width > 0 [precondition]
     */
    public ClearBox(double height, double width) {
	super(height, width, '*', ' ');
    }

    /**
     * @return ration [postcondition]
     */
    public double getRatio() {
	return width / height;
    }

    /**
     * if height or width <= 2.0 the returned box is consists only of border [postcondition]
     * picture uses only characters provided in constructor [postcondition]
     * border of picture is drawn with this.border and content with this.border [postcondition]
     * border and content have to use different characters [postcondition]
     * @return drawn height = ceiling height & drawn width = ceiling width [postcondition]
     */
    public String toString() {
	return super.toString();
    }
}
