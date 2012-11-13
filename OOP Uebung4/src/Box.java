import java.lang.Math;

/**
 * fixed ratio [invariant]
 * border and content can not be changed [invariant]
 */
class Box extends FreeBox implements Pict {
    private char border;
    private char content;

    /**
     * @param height > 0 [precondition]
     * @param width > 0 [precondition]
     * @param border != space [precondition]
     */
    public Box(double height, double width, char border, char content) {
	this.height = height;
	this.width = width;
	this.border = border;
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
     * if height or width <= 2.0 the returned box is consists only of border [postcondition]
     * picture uses only characters provided in constructor [postcondition]
     * border of picture is drawn with this.border and content with this.border [postcondition]
     * border and content can use different characters [postcondition]
     * @return drawn height = ceiling height & drawn width = ceiling width [postcondition]
     */
    public String toString() {
	int heightRounded = (int)Math.ceil(this.height);
	int widthRounded = (int)Math.ceil(this.width);
	String picture = "";

	if(this.height <= 1.0 | this.width <= 1.0) {
	    for(int i = 0; i < heightRounded; i++) {
		for(int j = 0; j < widthRounded; j++) {
		    picture += this.border;
		}

		//don't linebreak on last row
		if(i != (heightRounded - 1)) {
		    picture += "\n";
		}
	    }
	} else {
	    //first row
	    for(int i = 0; i < widthRounded; i++) {
		picture += this.border;
	    }
	    
	    //all rows minus last row
	    for(int i = 0; i < (heightRounded - 2); i++) {
		picture += "\n" + this.border;

		for(int j = 0; j < (widthRounded - 2); j++) {
		    picture += this.content;
		}

		picture += this.border;
	    }

	    picture += "\n";

	    //last row
	    for(int i = 0; i < widthRounded; i++) {
		picture += this.border;
	    }
	}

	return picture;
    }
}
