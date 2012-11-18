import java.util.ArrayList;
import java.lang.reflect.Array;

class Repeated<P> implements Pict {
    private P[][] matrix;

    public Repeated(P[][] matrix) {
	this.matrix = matrix;
    }

    public void scale(double factor) {
	return;
    }

    public String toString() {
	int height = Array.getLength(this.matrix);
	int width = Array.getLength(this.matrix[0]);
	int maxHeight = 0;
	int maxWidth = 0;
	ArrayList<ArrayList<ArrayList<String>>> text = new ArrayList<ArrayList<ArrayList<String>>>();
	String picture = "";
	String returnedString;

	for(int i = 0; i < height; i++) {
	    text.add(new ArrayList<ArrayList<String>>());

	    for(int j = 0; j < width; j++) {
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
	for(int i = 0; i < height; i++) {
	    for(int j = 0; j < width; j++) {
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

	for(int i = 0; i < height; i++) {
	    for(int j = 0; j < maxHeight; j++) {
		for(int k = 0; k < width; k++) {
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
		if(i != (height - 1) || j != (maxHeight - 1)) {
		    picture += "\n";
		}
	    }
	}

	return picture;
    }
}
