import java.util.Iterator;
import java.util.Map;

class Test {
    public static void main(String[] args) {
	List<Android> list = new List<Android>();
	
	System.out.println();
	System.out.println("Successful new androids");
	Android hilfskraft1 = new Hilfskraft(new BeruehrungssensitiveSkin(), new HilfskraftSoftware(), new ZertifikatStufe1(), new AktorKit1kW());
	Android gesellschafter1 = new Gesellschafter(new BeruehrungssensitiveSkin(), new GesellschafterSoftware(), new ZertifikatStufe1(), new AktorKit1kW());
	Android bauarbeiter1 = new Bauarbeiter(new HochfesteSkin(), new BauarbeiterSoftware(), new ZertifikatStufe3(), new AktorKit4kW());
	Android leibwaechter1 = new Leibwaechter(new GepanzerteSkin(), new LeibwaechterSoftware(), new ZertifikatStufe4(), new AktorKit4kW());
	Android kaempfer1 = new Kaempfer(new GepanzerteSkin(), new KaempferSoftware(), new ZertifikatStufe5(), new AktorKit12kW());
	Android objektbewacher1 = new Objektbewacher(new GepanzerteSkin(), new ObjektbewacherSoftware(), new ZertifikatStufe4(), new AktorKit4kW());
    Android servicetechniker1 = new ServiceTechniker(new HochfesteSkin(), new ServiceTechnikerSoftware(), new ZertifikatStufe4(), new AktorKit4kW());
    Android transportarbeiter1 = new Transportarbeiter(new BeruehrungssensitiveSkin(), new TransportarbeiterSoftware(), new ZertifikatStufe3(), new AktorKit4kW());
	System.out.println(list.insert(hilfskraft1,1));
	System.out.println(list.insert(gesellschafter1,2));
	System.out.println(list.insert(bauarbeiter1, 4));
	System.out.println(list.insert(leibwaechter1, 5));
	System.out.println(list.insert(kaempfer1, 6));
	System.out.println(list.insert(objektbewacher1, 7));
	System.out.println(list.insert(servicetechniker1, 8));
	System.out.println(list.insert(transportarbeiter1, 9));

	System.out.println();
	System.out.println("Failing new androids");
	Android hilfskraft2 = new Hilfskraft(new GepanzerteSkin(), new HilfskraftSoftware(), new ZertifikatStufe2(), new AktorKit1kW());
	Android gesellschafter2 = new Gesellschafter(new BeruehrungssensitiveSkin(), new GesellschafterSoftware(), new ZertifikatStufe4(), new AktorKit1kW());
	Android bauarbeiter2 = new Bauarbeiter(new HochfesteSkin(), new BauarbeiterSoftware(), new ZertifikatStufe4(), new AktorKit12kW());
	Android leibwaechter2 = new Leibwaechter(new GepanzerteSkin(), new LeibwaechterSoftware(), new ZertifikatStufe3(), new AktorKit4kW());
	Android kaempfer2 = new Kaempfer(new BeruehrungssensitiveSkin(), new KaempferSoftware(), new ZertifikatStufe4(), new AktorKit12kW());
	Android objektbewacher2 = new Objektbewacher(new GepanzerteSkin(), new ObjektbewacherSoftware(), new ZertifikatStufe5(), new AktorKit4kW());
	Android servicetechniker2 = new ServiceTechniker(new HochfesteSkin(), new ServiceTechnikerSoftware(), new ZertifikatStufe4(), new AktorKit12kW());
    Android transportarbeiter2 = new Transportarbeiter(new BeruehrungssensitiveSkin(), new TransportarbeiterSoftware(), new ZertifikatStufe2(), new AktorKit4kW());
    System.out.println(list.insert(hilfskraft2,21));
    System.out.println(list.insert(gesellschafter2,22));
    System.out.println(list.insert(bauarbeiter2, 23));
    System.out.println(list.insert(leibwaechter2, 24));
    System.out.println(list.insert(kaempfer2, 25));
    System.out.println(list.insert(objektbewacher2, 26));
    System.out.println(list.insert(servicetechniker2, 27));
    System.out.println(list.insert(transportarbeiter2, 28));
	
    System.out.println();
    System.out.println("All androids");
	Iterator<Map.Entry<Integer,Android>> iterator = list.iterator();
	while(iterator.hasNext()) {
	    System.out.println(iterator.next().getValue());
	}
	
	System.out.println();
	System.out.println("Find androids by serialnumber");
	System.out.println(list.find(2));
	System.out.println(list.find(6));
    System.out.println(list.find(99));
    
    System.out.println();
    System.out.println("Updating androids");
    Android gesellschafter3 = new Gesellschafter(new BeruehrungssensitiveSkin(), new GesellschafterSoftware(), new ZertifikatStufe1(), new AktorKit1kW());
    Android objektbewacher3 = new Objektbewacher(new GepanzerteSkin(), new ObjektbewacherSoftware(), new ZertifikatStufe4(), new AktorKit4kW());
    Android kaempfer3 = new Kaempfer(new HochfesteSkin(), new KaempferSoftware(), new ZertifikatStufe5(), new AktorKit12kW());
    Android bauarbeiter3 = new Bauarbeiter(new HochfesteSkin(), new BauarbeiterSoftware(), new ZertifikatStufe4(), new AktorKit1kW());
    Android objektbewacher4 = new Objektbewacher(new GepanzerteSkin(), new ObjektbewacherSoftware(), new ZertifikatStufe4(), new AktorKit4kW());
    Android bauarbeiter4 = new Bauarbeiter(new HochfesteSkin(), new BauarbeiterSoftware(), new ZertifikatStufe3(), new AktorKit1kW());
    Android leibwaechter3 = new Leibwaechter(new GepanzerteSkin(), new LeibwaechterSoftware(), new ZertifikatStufe4(), new AktorKit4kW());
    Android transportarbeiter3 = new Transportarbeiter(new BeruehrungssensitiveSkin(), new TransportarbeiterSoftware(), new ZertifikatStufe3(), new AktorKit4kW());
    System.out.println(list.insert(objektbewacher3, 6));
    System.out.println(list.insert(gesellschafter3, 1));
    System.out.println(list.insert(kaempfer3, 6));
    System.out.println(list.insert(bauarbeiter3, 9));
    System.out.println(list.insert(bauarbeiter3, 8));
    System.out.println(list.insert(objektbewacher4, 2));
    System.out.println(list.insert(bauarbeiter4, 4));
    System.out.println(list.insert(leibwaechter3, 2));
    System.out.println(list.insert(transportarbeiter3, 5));
    
    
    System.out.println();
    System.out.println("All androids");
    iterator = list.iterator();
    while(iterator.hasNext()) {
        System.out.println(iterator.next().getValue());
    }
    }
    
}
