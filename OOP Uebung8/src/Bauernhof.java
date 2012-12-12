class Bauernhof {
    private final String name;
    private LinkedList traktoren;

    public Bauernhof(String name) {
	this.name = name;
	this.traktoren = new LinkedList();
    }

    public String getName() {
	return this.name;
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

    /*
    public void change(Traktor traktor) {
	Traktor oldTraktor = this.getTraktor(traktor.getNummer());

	if(oldTraktor != null) {
	    this.remove(traktor.getNummer());
	    this.insert(traktor);
	}
    }
    */

    public void changeRole(int nummer, Role role) {
	Traktor traktor = this.getTraktor(nummer);
	
	if(traktor != null) {
	    traktor.changeRole(role);
	    //this.change(traktor);
	}
    }

    public void increaseBetriebsstunden(int nummer, int betriebsstunden) {
	Traktor traktor = this.getTraktor(nummer);

	if(traktor != null) {
	    traktor.increaseBetriebsstunden(betriebsstunden);
	    //this.change(traktor);
	}
    }

    public void increaseDiesel(int nummer, int diesel) {
	if(this.getTraktor(nummer) instanceof DieselTraktor) {
	    DieselTraktor traktor = (DieselTraktor)this.getTraktor(nummer);
	    traktor.increaseDiesel(diesel);
	    //this.change(traktor);
	}
    }

    public void increaseBiogas(int nummer, double biogas) {
	if(this.getTraktor(nummer) instanceof BiogasTraktor) {
	    BiogasTraktor traktor = (BiogasTraktor)this.getTraktor(nummer);
	    traktor.increaseBiogas(biogas);
	    //this.change(traktor);
	}
    }

    public void getBetriebsstunden() {
	LinkedList.LinkedListIterator iterator = this.traktoren.iterator();
	Traktor next = null;
	int betriebsstunden = 0;
	int betriebsstundenDrillmaschine = 0;
	int betriebsstundenDuengerstreuer = 0;
	int count = 0;
	int countDrillmaschine = 0;
	int countDuengerstreuer = 0;

	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();

	    if(next.getRole() instanceof Drillmaschine) {
		betriebsstundenDrillmaschine += next.getBetriebsstunden();
		countDrillmaschine++;
	    } else {
		betriebsstundenDuengerstreuer += next.getBetriebsstunden();
		countDuengerstreuer++;
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
	if(countDrillmaschine != 0) {
	    System.out.println((double)betriebsstundenDrillmaschine / countDrillmaschine);
	} else {
	    System.out.println("0");
	}

	System.out.print("Durchschnittliche Betriebsstunden aller Duengerstreuer: ");
	if(countDuengerstreuer != 0) {
	    System.out.println((double)betriebsstundenDuengerstreuer / countDuengerstreuer);
	} else {
	    System.out.println("0");
	}
    }

    public void getBetriebsstundenArt() {
	LinkedList.LinkedListIterator iterator = this.traktoren.iterator();
	Traktor next = null;
	int betriebsstundenDiesel = 0;
	int betriebsstundenBiogas = 0;
	int countDiesel = 0;
	int countBiogas = 0;

	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();

	    if(next instanceof DieselTraktor) {
		betriebsstundenDiesel += next.getBetriebsstunden();
		countDiesel++;
	    } else {
		betriebsstundenBiogas += next.getBetriebsstunden();
		countBiogas++;
	    }
	}

	System.out.print("Durchschnittliche Betriebsstunden aller Diesel Traktoren: ");
	if(countDiesel != 0) {
	    System.out.println((double)betriebsstundenDiesel / countDiesel);
	} else {
	    System.out.println("0");
	}

	System.out.print("Durchschnittliche Betriebsstunden aller Biogas Traktoren: ");
	if(countBiogas != 0) {
	    System.out.println((double)betriebsstundenBiogas / countBiogas);
	} else {
	    System.out.println("0");
	}
    }

    public void getDiesel() {
	LinkedList.LinkedListIterator iterator = this.traktoren.iterator();
	Object next = null;
	DieselTraktor traktor = null;
	int diesel = 0;
	int dieselDrillmaschine = 0;
	int dieselDuengerstreuer = 0;
	int count = 0;
	int countDrillmaschine = 0;
	int countDuengerstreuer = 0;

	while(iterator.hasNext()) {
	    next = iterator.next();

	    if(next instanceof DieselTraktor) {
		traktor = (DieselTraktor)next;
		diesel += traktor.getDiesel();
		count++;

		if(traktor.getRole() instanceof Drillmaschine) {
		    dieselDrillmaschine += traktor.getDiesel();
		    countDrillmaschine++;
		} else {
		   dieselDuengerstreuer += traktor.getDiesel(); 
		   countDuengerstreuer++;
		}
	    }
	}

	System.out.print("Durchschnittlicher Dieselverbrauch aller Diesel Traktoren: ");
	if(count != 0) {
	    System.out.println((double)diesel / count);
	} else {
	    System.out.println("0");
	}

	System.out.print("Durchschnittlicher Dieselverbrauch aller Diesel Drillmaschinen: ");
	if(countDrillmaschine != 0) {
	    System.out.println((double)dieselDrillmaschine / countDrillmaschine);
	} else {
	    System.out.println("0");
	}

	System.out.print("Durchschnittlicher Dieselverbrauch aller Diesel Duengerstreuer: ");
	if(countDuengerstreuer != 0) {
	    System.out.println((double)dieselDuengerstreuer / countDuengerstreuer);
	} else {
	    System.out.println("0");
	}
    }
}
