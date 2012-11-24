import java.util.Iterator;

class Test {
    public static void main(String[] args) {
	String error;
	List list = new List();

	Skin beruehrungssensitiveSkin = new BeruehrungssensitiveSkin();
	Skin gepanzerteSkin = new GepanzerteSkin();

	Android hilfskraft = new Hilfskraft(beruehrungssensitiveSkin);
	Android bauarbeiter = new Bauarbeiter(gepanzerteSkin);

	if((error = list.insert(hilfskraft)) != null) {
	    System.out.println(error);
	}

	if((error = list.insert(bauarbeiter)) != null) {
	    System.out.println(error);
	}

	Iterator iterator = list.iterator();

	while(iterator.hasNext()) {
	    System.out.println(iterator.next());
	}
    }
}
