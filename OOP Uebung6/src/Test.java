import java.util.Iterator;
import java.util.Map;

class Test {
    public static void main(String[] args) {
	List<Android> list = new List<Android>();

	Skin beruehrungssensitiveSkin = new BeruehrungssensitiveSkin();
	Skin gepanzerteSkin = new GepanzerteSkin();

	Zertifikat zertifikatStufe1 = new ZertifikatStufe1();
	Zertifikat zertifikatStufe2 = new ZertifikatStufe2();
	Zertifikat zertifikatStufe4 = new ZertifikatStufe4();

	Software hilfskraftSoftware = new HilfskraftSoftware(zertifikatStufe2);
	Software gesellschafterSoftware = new GesellschafterSoftware(zertifikatStufe1);
	Software gesellschafterSoftware2 = new GesellschafterSoftware(zertifikatStufe4);

	Android hilfskraft = new Hilfskraft(beruehrungssensitiveSkin, hilfskraftSoftware);
	Android gesellschafter = new Gesellschafter(beruehrungssensitiveSkin, gesellschafterSoftware);
	Android gesellschafter2 = new Gesellschafter(beruehrungssensitiveSkin, gesellschafterSoftware2);

	System.out.println(list.insert(hilfskraft,123));
	System.out.println(list.insert(gesellschafter,145));
    System.out.println(list.insert(gesellschafter2,156));

	Iterator<Map.Entry<Integer,Android>> iterator = list.iterator();
	System.out.println("All androids");
	while(iterator.hasNext()) {
	    System.out.println(iterator.next().getValue());
	}
	System.out.println("Find serialnumber 145");
    System.out.println(list.find(145));
    }
    
}
