class Bauernhof {
    private final String name;
    private LinkedList traktoren;

    public Bauernhof(String name) {
	this.name = name;
	this.traktoren = new LinkedList();
    }

    public void insert(Traktor traktor) {
	LinkedList.LinkedListIterator iterator = this.traktoren.iterator();
	Traktor next = null;

	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();

	    //nicht einfuegen wenn seriennummer bereits vorhanden
	    if(next.getNummer() == traktor.getNummer()) {
		return;
	    }
	}

	this.traktoren.insert(traktor);
    }

    public void remove(int nummer) {
	LinkedList.LinkedListIterator iterator = this.traktoren.iterator();
	Traktor next = null;

	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();
	    
	    if(next.getNummer() == nummer) {
		iterator.remove();
		return;
	    }
	}
    }
}
