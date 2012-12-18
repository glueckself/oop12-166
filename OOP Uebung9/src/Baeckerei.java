
class Baeckerei {
    private RundkeksBackmaschine rundkeksBM;
    private MondkeksBackmaschine mondkeksBM;
    private WMannkeksBackmaschine wmannkeksBM;
    private DoppelkeksBackmaschine doppelkeksBM;
    
    public Baeckerei() {
        this.rundkeksBM = new RundkeksBackmaschine();
        this.mondkeksBM = new MondkeksBackmaschine();
        this.wmannkeksBM = new WMannkeksBackmaschine();
        this.doppelkeksBM = new DoppelkeksBackmaschine();
    }
    
    public Keksdose bestellen(Bestellung bestellung) {
        Keksdose dose = new Keksdose();
        KeksbackManager manager = new KeksbackManager();
        Keks keks = null;
        for(Position pos : bestellung.getPositionen()) {
            for(int i=0; i<pos.getAnzahl(); i++) {
                if(pos.getForm() instanceof Rund) {
                    manager.set(rundkeksBM);
                    keks = manager.neuerKeks(pos.getTeig());
                }
                else if(pos.getForm() instanceof Mond) {
                    manager.set(mondkeksBM);
                    keks = manager.neuerKeks(pos.getTeig());
                }
                else if(pos.getForm() instanceof Weihnachtsmann) {
                    manager.set(wmannkeksBM);
                    keks = manager.neuerKeks(pos.getTeig());
                }
                if(pos.getFuellung() != null) {
                    keks = this.doppelkeksBM.backe((Einzelkeks)keks, pos.getFuellung());
                }
                dose.addKeks(keks);
            }
        }
        return dose;
    }
}
