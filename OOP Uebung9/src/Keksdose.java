import java.util.ArrayList;

class Keksdose {
    private ArrayList<Keks> kekse;
    
    public void inhalt() {
        System.out.println("Inhalt");
        for(Keks keks : kekse) {
            System.out.println(keks.toString());
        }
    }
}
