import java.util.ArrayList;
import java.lang.Math;

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
	this.width *= factor;
    }

    /**
     * picture uses only characters provided in constructor [postcondition]
     * @return drawn height = ceiling height & drawn width = ceiling width [postcondition]
     */
    public String toString() {
	String picture = "";
	int roundedWidth = (int)Math.ceil(this.width);
	int rest;

	//add this.text row per row to picture
	for(int i = 0; i < this.height; i++) {
	    //as long as roundedWith is greater than textWidth, add the same text row multiple times to picture
	    for(rest = roundedWidth; rest >= this.textWidth; rest -= this.textWidth) {
		picture += this.text.get(i);
	    }

	    //add a part of the current text row to picture. the length of the part is corresponding to rest
	    picture += this.text.get(i).substring(0, rest);

	    //don't add linebreak on last row
	    if(i != (this.height - 1)) {
		picture += "\n";
	    }
	}

	return picture;
    }
}
