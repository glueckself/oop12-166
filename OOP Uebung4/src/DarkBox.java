/**
 * fixed ratio [invariant]
 * border and content are the same characters [invariant]
 */
class DarkBox implements Pict {
    private double height;
    private double width;
    private char border;

    /**
     * @param height > 0 [precondition]
     * @param width > 0 [precondition]
     * @param content != space [precondition]
     */
    public DarkBox(double height, double width, char content) {
	this.height = height;
	this.width = width;
	this.border = content;
    }

    /**
     * this.content is set to content [postcondition]
     * @param content != space [precondition]
     */
    public void setBorder(char border) {
	this.border = border;
    }

    /**
     * height = height * factor and width = width * factor [postcondition]
     */
    public void scale(double factor) {
	this.height = this.height * factor;
	this.width = this.width * factor;
    }

    /**
     * border and content of the picture are drawn with this.border [postcondition]
     * drawn height = rounded height & drawn width = rounded width [postcondition]
     */
    public String toString() {
	int heightRounded = (int)Math.ceil(this.height);
	int widthRounded = (int)Math.ceil(this.width);
	String picture = "";

	for(int i = 0; i < heightRounded; i++) {
	    for(int j = 0; j < widthRounded; j++) {
		picture += this.border;
	    }

	    //don't linebreak on last row
	    if(i != (heightRounded - 1)) {
		picture += "\n";
	    }
	}

	return picture;
    }
}
