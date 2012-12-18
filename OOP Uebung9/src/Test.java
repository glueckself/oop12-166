
class Test {

    public static void main(String[] args) {
        Baeckerei baeckerei = new Baeckerei();
        Keksdose dose1 = new Keksdose();
        Position pos1 = new Position(5,new Rund(),new Muerbteig());
        Position pos2 = new Position(7,new Weihnachtsmann(),new Zimtsternteig());
        Position pos3 = new Position(3,new Mond(),new Schokoladenteig(),new Schokolade());
        Bestellung best1 = new Bestellung();
        best1.addPosition(pos1);
        best1.addPosition(pos2);
        best1.addPosition(pos3);
        best1.drucke();
        dose1 = baeckerei.bestellen(best1);
        dose1.inhalt();
    }

}
