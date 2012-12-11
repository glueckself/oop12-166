class Test {
    public static void main(String[] args) {
	LinkedList list = new LinkedList();
	
	Drillmaschine drill1 = new Drillmaschine(4);
	Traktor traktor = new BiogasTraktor(1,drill1);
	Traktor output = null;

	list.insert(traktor);

	LinkedList.LinkedListIterator iterator = list.iterator();

	while(iterator.hasNext()) {
	    output = (Traktor)iterator.next();
	    System.out.println(output.getBetriebsstunden());
	}
    }
}
