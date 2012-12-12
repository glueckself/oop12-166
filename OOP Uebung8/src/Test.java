class Test {
    
    public static void main(String[] args) {
	LinkedList bauernhoefe = new LinkedList();

	Bauernhof bauernhof1 = new Bauernhof("Bauernhof1");
	Bauernhof bauernhof2 = new Bauernhof("Bauernhof2");
	Bauernhof bauernhof3 = new Bauernhof("Bauernhof3");

	Drillmaschine drill4 = new Drillmaschine(4);
	Drillmaschine drill7 = new Drillmaschine(7);
	Drillmaschine drill3 = new Drillmaschine(3);
	Drillmaschine drill12 = new Drillmaschine(12);
	Drillmaschine drill5 = new Drillmaschine(5);
	Drillmaschine drill6 = new Drillmaschine(6);
	Drillmaschine drill8 = new Drillmaschine(8);
	Drillmaschine drill9 = new Drillmaschine(9);
	Drillmaschine drill10 = new Drillmaschine(2);
	Duengerstreuer duenger4_3 = new Duengerstreuer(4.3);
	Duengerstreuer duenger1_7 = new Duengerstreuer(1.7);
	Duengerstreuer duenger3_2 = new Duengerstreuer(3.2);
	Duengerstreuer duenger3_5 = new Duengerstreuer(3.5);
	Duengerstreuer duenger9_1 = new Duengerstreuer(9.1);
	Duengerstreuer duenger8_8 = new Duengerstreuer(8.8);
	Duengerstreuer duenger4_6 = new Duengerstreuer(4.6);
	Duengerstreuer duenger5_6 = new Duengerstreuer(5.6);
	Traktor biogas1 = new BiogasTraktor(1,drill4);
	Traktor diesel2 = new DieselTraktor(2,drill7);
	Traktor biogas3 = new BiogasTraktor(3,duenger1_7);
	Traktor biogas4 = new BiogasTraktor(4,duenger4_3);
	Traktor diesel5 = new DieselTraktor(5,drill3);
	Traktor diesel6 = new DieselTraktor(6,duenger3_2);
	Traktor diesel7 = new DieselTraktor(7,duenger3_5);
	Traktor biogas8 = new BiogasTraktor(8,duenger9_1);
	Traktor biogas9 = new BiogasTraktor(9,drill12);
	Traktor diesel10 = new DieselTraktor(10,drill5);
	Traktor diesel11 = new DieselTraktor(11,duenger8_8);
	Traktor biogas12 = new BiogasTraktor(12,drill6);
	Traktor diesel13 = new DieselTraktor(13,drill10);
	Traktor biogas13 = new BiogasTraktor(13,duenger4_6);
	

	bauernhoefe.insert(bauernhof1);
	bauernhoefe.insert(bauernhof2);
	bauernhoefe.insert(bauernhof3);

	get(bauernhoefe,"Bauernhof1").insert(biogas1);
	get(bauernhoefe,"Bauernhof1").insert(diesel2);
	get(bauernhoefe,"Bauernhof1").insert(biogas3);
	get(bauernhoefe,"Bauernhof1").insert(biogas4);
	get(bauernhoefe,"Bauernhof1").insert(diesel5);
	get(bauernhoefe,"Bauernhof2").insert(diesel6);
    get(bauernhoefe,"Bauernhof2").insert(diesel7);
    get(bauernhoefe,"Bauernhof2").insert(biogas8);
    get(bauernhoefe,"Bauernhof2").insert(biogas9);
    get(bauernhoefe,"Bauernhof2").insert(diesel13); 
    get(bauernhoefe,"Bauernhof2").insert(biogas13); //darf nicht hinzugefügt werden, 13 schon vergeben
    get(bauernhoefe,"Bauernhof3").insert(diesel10);
    get(bauernhoefe,"Bauernhof3").insert(diesel11);
    get(bauernhoefe,"Bauernhof3").insert(biogas12);
    get(bauernhoefe,"Bauernhof3").insert(biogas13);
	
    get(bauernhoefe,"Bauernhof1").increaseBetriebsstunden(1, 4);
    get(bauernhoefe,"Bauernhof1").increaseBetriebsstunden(2, 3);
    get(bauernhoefe,"Bauernhof1").increaseBetriebsstunden(3, 9);
    get(bauernhoefe,"Bauernhof1").increaseBetriebsstunden(4, 6);
    get(bauernhoefe,"Bauernhof1").increaseBetriebsstunden(5, 7);
    get(bauernhoefe,"Bauernhof2").increaseBetriebsstunden(6, 14);
    get(bauernhoefe,"Bauernhof2").increaseBetriebsstunden(7, 6);
    get(bauernhoefe,"Bauernhof2").increaseBetriebsstunden(8, 9);
    get(bauernhoefe,"Bauernhof2").increaseBetriebsstunden(9, 8);
    get(bauernhoefe,"Bauernhof3").increaseBetriebsstunden(10, 7);
    get(bauernhoefe,"Bauernhof3").increaseBetriebsstunden(11, 9);
    get(bauernhoefe,"Bauernhof3").increaseBetriebsstunden(12, 12);
    get(bauernhoefe,"Bauernhof3").increaseBetriebsstunden(13, 4);
    
    get(bauernhoefe,"Bauernhof1").increaseBiogas(1, 12.2);
    get(bauernhoefe,"Bauernhof1").increaseDiesel(2, 11);
    get(bauernhoefe,"Bauernhof1").increaseBiogas(3, 6.3);
    get(bauernhoefe,"Bauernhof1").increaseBiogas(4, 9.6);
    get(bauernhoefe,"Bauernhof1").increaseDiesel(5, 9);
    get(bauernhoefe,"Bauernhof2").increaseDiesel(6, 25);
    get(bauernhoefe,"Bauernhof2").increaseDiesel(7, 4);
    get(bauernhoefe,"Bauernhof2").increaseBiogas(8, 11.7);
    get(bauernhoefe,"Bauernhof2").increaseBiogas(9, 4.0);
    get(bauernhoefe,"Bauernhof3").increaseDiesel(10, 8);
    get(bauernhoefe,"Bauernhof3").increaseDiesel(11, 13);
    get(bauernhoefe,"Bauernhof3").increaseBiogas(12, 8.9);
    get(bauernhoefe,"Bauernhof3").increaseBiogas(13, 1.2);
     
    get(bauernhoefe,"Bauernhof1").remove(1);
    get(bauernhoefe,"Bauernhof1").changeRole(4, drill8);
    get(bauernhoefe,"Bauernhof1").changeRole(2, drill9);
    get(bauernhoefe,"Bauernhof3").remove(12);
    get(bauernhoefe,"Bauernhof3").changeRole(10, duenger5_6);
	
    
    

	System.out.println("Bauernhof1");
	get(bauernhoefe,"Bauernhof1").getBetriebsstunden();
    get(bauernhoefe,"Bauernhof1").getBetriebsstundenArt();
    get(bauernhoefe,"Bauernhof1").getDiesel();
    get(bauernhoefe,"Bauernhof1").getBiogas();
    get(bauernhoefe,"Bauernhof1").getMinMaxSaescharen();
    get(bauernhoefe,"Bauernhof1").getKapazitaet();
    System.out.println();
    System.out.println("Bauernhof2");
    get(bauernhoefe,"Bauernhof2").getBetriebsstunden();
    get(bauernhoefe,"Bauernhof2").getBetriebsstundenArt();
    get(bauernhoefe,"Bauernhof2").getDiesel();
    get(bauernhoefe,"Bauernhof2").getBiogas();
    get(bauernhoefe,"Bauernhof2").getMinMaxSaescharen();
    get(bauernhoefe,"Bauernhof2").getKapazitaet();
    System.out.println();
    System.out.println("Bauernhof3");
    get(bauernhoefe,"Bauernhof3").getBetriebsstunden();
    get(bauernhoefe,"Bauernhof3").getBetriebsstundenArt();
    get(bauernhoefe,"Bauernhof3").getDiesel();
    get(bauernhoefe,"Bauernhof3").getBiogas();
    get(bauernhoefe,"Bauernhof3").getMinMaxSaescharen();
    get(bauernhoefe,"Bauernhof3").getKapazitaet();

    System.out.println();
	MetaPrinter printer = new MetaPrinter();
	printer.print(printer);
	printer.print(duenger4_3);
    printer.print(drill4);
	printer.print(bauernhof1);
	printer.print(biogas1);
    printer.print(diesel2);
    printer.print(bauernhoefe);
    }
    
    private static Bauernhof get(LinkedList bauernhoefe, String name) {
        LinkedList.LinkedListIterator iterator = bauernhoefe.iterator();
        Bauernhof next = null;

        while(iterator.hasNext()) {
            next = (Bauernhof)iterator.next();
            if(next.getName().equals(name)) {
                return next;
            }
        }
        return null;
    }
}
