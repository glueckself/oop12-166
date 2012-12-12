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

	return null;
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

    public void getBiogas() {
	LinkedList.LinkedListIterator iterator = this.traktoren.iterator();
	Object next = null;
	BiogasTraktor traktor = null;
	double biogas = 0;
	double biogasDrillmaschine = 0;
	double biogasDuengerstreuer = 0;
	int count = 0;
	int countDrillmaschine = 0;
	int countDuengerstreuer = 0;

	while(iterator.hasNext()) {
	    next = iterator.next();

	    if(next instanceof BiogasTraktor) {
		traktor = (BiogasTraktor)next;
		biogas += traktor.getBiogas();
		count++;

		if(traktor.getRole() instanceof Drillmaschine) {
		    biogasDrillmaschine += traktor.getBiogas();
		    countDrillmaschine++;
		} else {
		   biogasDuengerstreuer += traktor.getBiogas(); 
		   countDuengerstreuer++;
		}
	    }
	}

	System.out.print("Durchschnittlicher Biogasverbrauch aller Biogas Traktoren: ");
	if(count != 0) {
	    System.out.println(biogas / count);
	} else {
	    System.out.println("0");
	}

	System.out.print("Durchschnittlicher Biogasverbrauch aller Biogas Drillmaschinen: ");
	if(countDrillmaschine != 0) {
	    System.out.println(biogasDrillmaschine / countDrillmaschine);
	} else {
	    System.out.println("0");
	}

	System.out.print("Durchschnittlicher Biogasverbrauch aller Biogas Duengerstreuer: ");
	if(countDuengerstreuer != 0) {
	    System.out.println(biogasDuengerstreuer / countDuengerstreuer);
	} else {
	    System.out.println("0");
	}
    }

    public void getMinMaxSaescharen() {
	LinkedList.LinkedListIterator iterator = this.traktoren.iterator();
	Traktor next = null;
	Drillmaschine drillmaschine = null;
	int minSaeschare = 0;
	int maxSaeschare = 0;
	int minSaeschareDiesel = 0;
	int maxSaeschareDiesel = 0;
	int minSaeschareBiogas = 0;
	int maxSaeschareBiogas = 0;

	// erste werte fuer min und max finden
	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();

	    if(next.getRole() instanceof Drillmaschine) {
		drillmaschine = (Drillmaschine)next.getRole();
		minSaeschare = drillmaschine.getSaeschare();
		maxSaeschare = minSaeschare;
		break;
	    }
	}

	iterator = this.traktoren.iterator();

	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();

	    if(next instanceof DieselTraktor && next.getRole() instanceof Drillmaschine) {
		drillmaschine = (Drillmaschine)next.getRole();
		minSaeschareDiesel = drillmaschine.getSaeschare();
		maxSaeschareDiesel = minSaeschareDiesel;
		break;
	    }
	}

	iterator = this.traktoren.iterator();

	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();

	    if(next instanceof DieselTraktor && next.getRole() instanceof Drillmaschine) {
		drillmaschine = (Drillmaschine)next.getRole();
		minSaeschareBiogas = drillmaschine.getSaeschare();
		maxSaeschareBiogas = minSaeschareBiogas;
		break;
	    }
	}

	iterator = this.traktoren.iterator();

	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();

	    if(next.getRole() instanceof Drillmaschine) {
		drillmaschine = (Drillmaschine)next.getRole();

		if(drillmaschine.getSaeschare() < minSaeschare) {
		    minSaeschare = drillmaschine.getSaeschare();
		}

		if(drillmaschine.getSaeschare() > maxSaeschare) {
		    maxSaeschare = drillmaschine.getSaeschare();
		}

		if(next instanceof DieselTraktor) {
		    if(drillmaschine.getSaeschare() < minSaeschareDiesel) {
			minSaeschareDiesel = drillmaschine.getSaeschare();
		    }

		    if(drillmaschine.getSaeschare() > maxSaeschareDiesel) {
			maxSaeschareDiesel = drillmaschine.getSaeschare();
		    }
		} else {
		    if(drillmaschine.getSaeschare() < minSaeschareBiogas) {
			minSaeschareBiogas = drillmaschine.getSaeschare();
		    }

		    if(drillmaschine.getSaeschare() > maxSaeschareBiogas) {
			maxSaeschareBiogas = drillmaschine.getSaeschare();
		    }
		}
	    }
	}

	System.out.print("Min. Saeschare insgesamt: " + minSaeschare);
	System.out.print("Max. Saeschare insgesamt: " + maxSaeschare);

	System.out.print("Min. Saeschare der Diesel Traktoren: " + minSaeschareDiesel);
	System.out.print("Max. Saeschare der Diesel Traktoren: " + maxSaeschareDiesel);

	System.out.print("Min. Saeschare der Biogas Traktoren: " + minSaeschareBiogas);
	System.out.print("Max. Saeschare der Biogas Traktoren: " + maxSaeschareBiogas);
    }

    public void getKapazitaet() {
	LinkedList.LinkedListIterator iterator = this.traktoren.iterator();
	Traktor next = null;
	Duengerstreuer duengerstreuer = null;
	double kapazitaet = 0;
	double kapazitaetDiesel = 0;
	double kapazitaetBiogas = 0;
	int count = 0;
	int countDiesel = 0;
	int countBiogas = 0;

	while(iterator.hasNext()) {
	    next = (Traktor)iterator.next();

	    if(next.getRole() instanceof Duengerstreuer) {
		duengerstreuer = (Duengerstreuer)next.getRole();
		kapazitaet += duengerstreuer.getKapazitaet();
		count++;

		if(next instanceof DieselTraktor) {
		    kapazitaetDiesel += duengerstreuer.getKapazitaet();
		    countDiesel++;
		} else {
		    kapazitaetBiogas += duengerstreuer.getKapazitaet();
		    countBiogas++;
		}
	    }
	}

	System.out.print("Durchschnittliche Fassungskapazitaet des Duengerbehaelters insgesamt: ");
	if(count != 0) {
	    System.out.println(kapazitaet / count);
	} else {
	    System.out.println("0");
	}

	System.out.print("Durchschnittliche Fassungskapazitaet des Duengerbehaelters aller Diesel Traktoren: ");
	if(countDiesel != 0) {
	    System.out.println(kapazitaetDiesel / countDiesel);
	} else {
	    System.out.println("0");
	}

	System.out.print("Durchschnittliche Fassungskapazitaet des Duengerbehaelters aller Biogas Traktoren: ");
	if(countBiogas != 0) {
	    System.out.println(kapazitaetBiogas / countBiogas);
	} else {
	    System.out.println("0");
	}
    }
}
