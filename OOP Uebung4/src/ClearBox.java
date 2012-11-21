/**
 * fixed ratio [invariant]
 * once set, drawing values (border,content) can't be changed [invariant]
 * '*' used as border, and ' ' used as content [invariant]
 * border and content are therefore different characters [invariant]
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
     * if height or width <= 2.0 the returned box consists only of border [postcondition]
     * border of picture is drawn with this.border and content with this.content [postcondition]
     * drawn height = rounded height & drawn width = rounded width [postcondition]
     */
    public String toString() {
	return super.toString();
    }
}
