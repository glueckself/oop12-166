import java.util.ArrayList;

class Keksdose {
    private ArrayList<Keks> kekse;
    
    public void addKeks(Keks keks) {
        this.kekse.add(keks);
    }
    
    public void inhalt() {
        System.out.println("Inhalt");
        for(Keks keks : kekse) {
            System.out.println(keks.toString());
        }
    }
}
