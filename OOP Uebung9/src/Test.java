
class Test {

    public static void main(String[] args) {
        Position pos1 = new Position(5,new Rund(),new Muerbteig());
        Position pos2 = new Position(7,new Weihnachtsmann(),new Zimtsternteig());
        Bestellung best1 = new Bestellung();
        best1.addPosition(pos1);
        best1.addPosition(pos2);
        best1.drucke();
        Einzelkeks keks1 = new Einzelkeks(new Rund(),new Muerbteig());
        DoppelkeksBackmaschine dkb = new DoppelkeksBackmaschine();
        System.out.println(dkb.backe(keks1, new Schokolade()));
    }

}
