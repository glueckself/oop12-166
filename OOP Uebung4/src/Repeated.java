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
	System.out.println("height: " + height);
	int width = Array.getLength(this.matrix[0]);
	System.out.println("width: " + width);
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
		    for(int k = 0; k < returnedString.length(); k = returnedString.indexOf('\n', k + 1) + 1) {
			if(returnedString.indexOf('\n', k + 1) == -1) {
			    text.get(i).get(j).add(returnedString.substring(k, returnedString.length()));
			    break;
			}

			text.get(i).get(j).add(returnedString.substring(k, returnedString.indexOf('\n', k + 1)));
		    }
		}
	    }
	}

	for(int i = 0; i < height; i++) {
	    for(int j = 0; j < text.get(i).get(0).size(); j++) {
		for(int k = 0; k < width; k++) {
		    picture += text.get(i).get(k).get(j);
		}

		picture += "\n";
	    }
	    
	    //picture += "\n";
	}

	return picture;
    }
}
