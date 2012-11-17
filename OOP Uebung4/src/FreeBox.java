import java.util.ArrayList;

/**
 * fixed ratio [invariant]
 * text can not be changed [invariant]
 */
class FreeBox implements Pict {
    protected double height;
    protected double width;
    private int stringHeight;
    private int stringWidth;
    private ArrayList<String> text;

    public FreeBox() {
	return;
    }

    /**
     * @param text length > 0 & rectangular[precondition]
     */
    public FreeBox(String text) {
	this.text = new ArrayList<String>();
	int index = text.indexOf('\n');
	int i;

	//check if rectangular
	for(i = 0; i < text.length(); i += index + 1) {
	    if(text.charAt(index) != '\n') {
		throw new IllegalArgumentException("text not rectangular");
	    }
	}

	if(text.charAt(text.length() - 1 - index) != '\n') {
	    throw new IllegalArgumentException("text not rectangular");
	}

	//copy row per row into this.text
	for(int j = 0; j < text.length(); j = j + index + 1) {
	    this.text.add(text.substring(j, j + index));
	}
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
	String picture = "";

	//add this.text row per row to picture
	for(int i = 0; i < text.size(); i++) {
	    picture += text.get(i);    

	    if(i != (text.size() - 1)) {
		picture += "\n";
	    }
	}

	return picture;
    }
}
