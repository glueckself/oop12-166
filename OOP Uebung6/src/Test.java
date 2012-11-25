import java.util.Iterator;

class Test {
    public static void main(String[] args) {
	String error;
	List<Android> list = new List<Android>();

	Skin beruehrungssensitiveSkin = new BeruehrungssensitiveSkin();
	Skin gepanzerteSkin = new GepanzerteSkin();

	Zertifikat zertifikatStufe1 = new ZertifikatStufe1();
	Zertifikat zertifikatStufe2 = new ZertifikatStufe2();

	Software hilfskraftSoftware = new HilfskraftSoftware(zertifikatStufe1);
	Software gesellschafterSoftware = new GesellschafterSoftware(zertifikatStufe1);

	Android hilfskraft = new Hilfskraft(beruehrungssensitiveSkin, hilfskraftSoftware);
	Android gesellschafter = new Gesellschafter(beruehrungssensitiveSkin, gesellschafterSoftware);

	if((error = list.insert(hilfskraft)) != null) {
	    System.out.println(error);
	}

	if((error = list.insert(gesellschafter)) != null) {
	    System.out.println(error);
	}

	Iterator<Android> iterator = list.iterator();

	while(iterator.hasNext()) {
	    System.out.println(iterator.next());
	}
    }
}
