import java.util.ArrayList;

/**
 * fixed ratio [invariant]
 * text can not be changed [invariant]
 */
class FreeBox implements Pict {
    protected double height;
    protected double width;
    private int textWidth;
    private ArrayList<String> text;

    public FreeBox() {
	return;
    }

    /**
     * @param text length > 0 & rectangular[precondition]
     */
    public FreeBox(String text) {
	this.text = new ArrayList<String>();
	int firstLineBreak = text.indexOf('\n');
	int lastLineBreak;

	//check if rectangular
	for(lastLineBreak = firstLineBreak; lastLineBreak < text.length(); lastLineBreak += firstLineBreak + 1) {
	    if(text.charAt(lastLineBreak) != '\n') {
		throw new IllegalArgumentException("text not rectangular");
	    }
	}

	//check if last row of text is as long as the other rows
	if(text.charAt(text.length() - 1 - firstLineBreak) != '\n') {
	    throw new IllegalArgumentException("text not rectangular");
	}

	//copy row per row into this.text
	for(int j = 0; j < text.length(); j = j + firstLineBreak + 1) {
	    this.text.add(text.substring(j, j + firstLineBreak));
	}

	//set height & width
	this.height = this.text.size();
	this.width = this.textWidth = firstLineBreak;
    }
    
    /**
     * width = width * factor [postcondition]
     */
    public void scale(double factor) {
	this.width = this.width * factor;
    }

    /**
     * picture uses only characters provided in constructor [postcondition]
     * @return drawn height = ceiling height & drawn width = ceiling width [postcondition]
     */
    public String toString() {
	String picture = "";

	//add this.text row per row to picture
	for(int i = 0; i < this.height; i++) {
	    picture += text.get(i);    

	    if(i != (this.height - 1)) {
		picture += "\n";
	    }
	}

	return picture;
    }
}
