class Test {
    public static void main(String[] args) {
	LinkedList list = new LinkedList();

	Traktor traktor = new DrillmaschineBiogasTraktor(1);
	Traktor output = null;

	list.insert(traktor);

	LinkedList.LinkedListIterator iterator = list.iterator();

	while(iterator.hasNext()) {
	    output = (Traktor)iterator.next();
	    System.out.println(output.getBetriebsstunden());
	}
    }
}
