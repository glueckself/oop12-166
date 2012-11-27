import java.util.Iterator;
import java.util.Map;

class Test {
    public static void main(String[] args) {
	List<Android> list = new List<Android>();

	Skin beruehrungssensitiveSkin = new BeruehrungssensitiveSkin();
	Skin hochfesteSkin = new HochfesteSkin();
	Skin gepanzerteSkin = new GepanzerteSkin();

	Zertifikat zertifikatStufe1 = new ZertifikatStufe1();
	Zertifikat zertifikatStufe2 = new ZertifikatStufe2();
	Zertifikat zertifikatStufe3 = new ZertifikatStufe3();
	Zertifikat zertifikatStufe4 = new ZertifikatStufe4();
	Zertifikat zertifikatStufe5= new ZertifikatStufe5();

	Software hilfskraftSoftware = new HilfskraftSoftware();
	Software gesellschafterSoftware = new GesellschafterSoftware();
	Software gesellschafterSoftware2 = new GesellschafterSoftware();
	Software bauarbeiterSoftware = new BauarbeiterSoftware();
	Software leibwaechterSoftware = new LeibwaechterSoftware();
	Software kaempferSoftware = new KaempferSoftware();

	AktorKit aktorKit1kW = new AktorKit1kW();
	AktorKit aktorKit4kW = new AktorKit4kW();
	AktorKit aktorKit12kW = new AktorKit12kW();

	Android hilfskraft = new Hilfskraft(beruehrungssensitiveSkin, hilfskraftSoftware, zertifikatStufe2, aktorKit1kW);
	Android gesellschafter = new Gesellschafter(beruehrungssensitiveSkin, gesellschafterSoftware, zertifikatStufe1, aktorKit1kW);
	Android gesellschafter2 = new Gesellschafter(beruehrungssensitiveSkin, gesellschafterSoftware2, zertifikatStufe4, aktorKit1kW);
	Android bauarbeiter = new Bauarbeiter(hochfesteSkin, bauarbeiterSoftware, zertifikatStufe3, aktorKit4kW);
	Android leibwaechter = new Leibwaechter(gepanzerteSkin, leibwaechterSoftware, zertifikatStufe4, aktorKit4kW);
	Android kaempfer = new Kaempfer(gepanzerteSkin, kaempferSoftware, zertifikatStufe5, aktorKit12kW);

	System.out.println(list.insert(hilfskraft,123));
	System.out.println(list.insert(gesellschafter,145));
	System.out.println(list.insert(gesellschafter2,156));
	System.out.println(list.insert(bauarbeiter, 155));
	System.out.println(list.insert(leibwaechter, 135));
	System.out.println(list.insert(kaempfer, 125));

	Iterator<Map.Entry<Integer,Android>> iterator = list.iterator();
	System.out.println("All androids");
	while(iterator.hasNext()) {
	    System.out.println(iterator.next().getValue());
	}
	System.out.println("Find serialnumber 145");
	System.out.println(list.find(145));
	System.out.println("Find serialnumber 155");
	System.out.println(list.find(155));
    }
    
}
