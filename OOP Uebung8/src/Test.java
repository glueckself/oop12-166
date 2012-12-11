class Test {
    public static void main(String[] args) {
	LinkedList bauernhoefe = new LinkedList();

	Bauernhof bauernhof1 = new Bauernhof("Bauernhof1");
	Bauernhof next = null;

	Drillmaschine drill1 = new Drillmaschine(4);
	Traktor biogas1 = new BiogasTraktor(1,drill1);

	bauernhoefe.insert(bauernhof1);

	LinkedList.LinkedListIterator iterator = bauernhoefe.iterator();

	while(iterator.hasNext()) {
	    next = (Bauernhof)iterator.next();
	    next.insert(biogas1);
	}

	iterator = bauernhoefe.iterator();

	while(iterator.hasNext()) {
	    next = (Bauernhof)iterator.next();
	    next.increaseBetriebsstunden(1, 10);
	    next.getBetriebsstunden();
	}

	MetaPrinter printer = new MetaPrinter();
	printer.print(printer);
	printer.print(biogas1);
    }
}
