class Bauernhof {
    private final String name;
    private LinkedList traktoren;

    public Bauernhof(String name) {
	this.name = name;
	this.traktoren = new LinkedList();
    }

    public Traktor getTraktor(int nummer) {
	LinkedList.LinkedListIterator iterator = this.traktoren.iterator();
	Traktor next = null;

	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();

	    if(next.getNummer() == nummer) {
		return next;
	    }
	}

	//null
	return next;
    }

    public void insert(Traktor traktor) {
	if(this.getTraktor(traktor.getNummer()) == null) {
	    this.traktoren.insert(traktor);
	}
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

    public void change(Traktor traktor) {
	Traktor oldTraktor = this.getTraktor(traktor.getNummer());

	if(oldTraktor != null) {
	    this.remove(traktor.getNummer());
	    this.insert(traktor);
	}
    }

    public void changeRole(int nummer, Role role) {
	Traktor traktor = this.getTraktor(nummer);
	
	if(traktor != null) {
	    traktor.changeRole(role);
	    this.change(traktor);
	}
    }

    public void increaseBetriebsstunden(int nummer, int betriebsstunden) {
	Traktor traktor = this.getTraktor(nummer);

	if(traktor != null) {
	    traktor.increaseBetriebsstunden(betriebsstunden);
	    this.change(traktor);
	}
    }

    public void increaseDiesel(int nummer, int diesel) {
	if(this.getTraktor(nummer) instanceof DieselTraktor) {
	    DieselTraktor traktor = (DieselTraktor)this.getTraktor(nummer);
	    traktor.increaseDiesel(diesel);
	    this.change(traktor);
	}
    }

    public void increaseBiogas(int nummer, double biogas) {
	if(this.getTraktor(nummer) instanceof BiogasTraktor) {
	    BiogasTraktor traktor = (BiogasTraktor)this.getTraktor(nummer);
	    traktor.increaseBiogas(biogas);
	    this.change(traktor);
	}
    }

    public void getBetriebsstunden() {
	LinkedList.LinkedListIterator iterator = this.traktoren.iterator();
	Traktor next = null;
	int betriebsstunden = 0;
	int drillmaschineBetriebsstunden = 0;
	int duengerstreuerBetriebsstunden = 0;
	int count = 0;
	int drillmaschineCount = 0;
	int duengerstreuerCount = 0;

	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();

	    if(next.getRole() instanceof Drillmaschine) {
		drillmaschineBetriebsstunden += next.getBetriebsstunden();
		drillmaschineCount++;
	    } else {
		duengerstreuerBetriebsstunden += next.getBetriebsstunden();
		duengerstreuerCount++;
	    }
	    
	    betriebsstunden += next.getBetriebsstunden();
	    count++;
	}

	System.out.print("Durchschnittliche Betriebsstunden aller Traktoren: ");
	if(count != 0) {
	    System.out.println((double)betriebsstunden / count);
	} else {
	    System.out.println("0");
	}

	System.out.print("Durchschnittliche Betriebsstunden aller Drillmaschinen: ");
	if(drillmaschineCount != 0) {
	    System.out.println((double)drillmaschineBetriebsstunden / drillmaschineCount);
	} else {
	    System.out.println("0");
	}

	System.out.print("Durchschnittliche Betriebsstunden aller Duengerstreuer: ");
	if(duengerstreuerCount != 0) {
	    System.out.println((double)duengerstreuerBetriebsstunden / duengerstreuerCount);
	} else {
	    System.out.println("0");
	}
    }
}
