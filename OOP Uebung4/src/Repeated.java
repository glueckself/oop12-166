import java.util.ArrayList;
import java.lang.Math;

/**
 * fixed ratio [invariant]
 * once set, drawing values (array) can't be changed [invariant]
 */
class Repeated<P> extends FreeBox implements Pict {
    private P[][] matrix;
    private int matrixHeight;
    private int matrixWidth;
    private double height;
    private double width;

    public Repeated(P[][] matrix) {
	this.matrix = matrix;
	this.matrixHeight = this.matrix.length;
	this.matrixWidth = this.matrix[0].length;
	this.height = this.matrixHeight;
	this.width = this.matrixWidth;
    }
    
    /**
     * height = height * factor and width = width * factor [postcondition]
     */
    public void scale(double factor) {
	this.height *= factor;
	this.width *= factor;
    }
    
    /**
     * drawn height = rounded height & drawn width = rounded width [postcondition]
     */
    public String toString() {
	int roundedHeight = (int)Math.ceil(this.height);
	int roundedWidth = (int)Math.ceil(this.width);
	int maxHeight = 0;
	int maxWidth = 0;
	ArrayList<ArrayList<ArrayList<String>>> text = new ArrayList<ArrayList<ArrayList<String>>>();
	String picture = "";
	String returnedString;

	for(int i = 0; i < this.matrixHeight; i++) {
	    text.add(new ArrayList<ArrayList<String>>());

	    for(int j = 0; j < this.matrixWidth; j++) {
		text.get(i).add(new ArrayList<String>());
		returnedString = matrix[i][j].toString();

		//if there is no linebreak, just add the row
		if(returnedString.indexOf('\n') == -1) {
		    text.get(i).get(j).add(returnedString);
		} else {
		    //copy row per row into text
		    //find linebreaks and separate the rows
		    for(int k = 0; k < returnedString.length(); k = returnedString.indexOf('\n', k + 1) + 1) {
			if(returnedString.indexOf('\n', k + 1) == -1) {
			    //last linebreak found, save the rest of the String as the last row
			    text.get(i).get(j).add(returnedString.substring(k, returnedString.length()));
			    break;
			}

			text.get(i).get(j).add(returnedString.substring(k, returnedString.indexOf('\n', k + 1)));
		    }
		}
	    }
	}

	//find max height and width
	for(int i = 0; i < this.matrixHeight; i++) {
	    for(int j = 0; j < this.matrixWidth; j++) {
		if(maxHeight < text.get(i).get(j).size()) {
		    maxHeight = text.get(i).get(j).size();
		}

		for(int k = 0; k < text.get(i).get(j).size(); k++) {
		    if(maxWidth < text.get(i).get(j).get(k).length()) {
			maxWidth = text.get(i).get(j).get(k).length();
		    }
		}
	    }
	}

	for(int i = 0, ix = 0; ix < roundedHeight; ix++) {
	    i = ix % this.matrixHeight;

	    for(int j = 0; j < maxHeight; j++) {
		for(int k = 0, kx = 0; kx < roundedWidth; kx++) {
		    k = kx % this.matrixWidth;

		    //fill with empty rows until maxHeight is reached
		    if(j >= text.get(i).get(k).size() && text.get(i).get(k).size() < maxHeight) {
			for(int l = 0; l < maxWidth; l++) {
			    picture += " ";
			}

			continue;
		    }

		    picture += text.get(i).get(k).get(j);
		    
		    //fill with spaces, until maxWidth is reached
		    for(int l = 0; l < (maxWidth - text.get(i).get(k).get(j).length()); l++) {
			picture += " ";
		    }
		}

		//don't linebreak on last row
		if(ix != (roundedHeight - 1) || j != (maxHeight - 1)) {
		    picture += "\n";
		}
	    }
	}

	return picture;
    }
}
