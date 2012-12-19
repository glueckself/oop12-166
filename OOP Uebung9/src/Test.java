class Test {
    public static void main(String[] args) {
        Baeckerei baeckerei = new Baeckerei();
        Keksdose dose1 = new Keksdose();

        Position pos1 = new Position(5,new Rund(),new Muerbteig());
        Position pos2 = new Position(7,new Weihnachtsmann(),new Zimtsternteig());
        Position pos3 = new Position(3,new Mond(),new Schokoladenteig(),new Schokolade());
        Position pos4 = new Position(2,new Weihnachtsmann(),new Muerbteig(),new Marmelade());

        Bestellung best1 = new Bestellung();

        best1.addPosition(pos1);
        best1.addPosition(pos2);
        best1.addPosition(pos3);
        best1.addPosition(pos4);

        best1.drucke();
        dose1 = baeckerei.bestellen(best1);
        dose1.inhalt();
        
        System.out.println("-----------------------------------------------------");
        Keksdose dose2 = new Keksdose();

        Position pos5 = new Position(1,new Rund(),new Zimtsternteig());
        Position pos6 = new Position(2,new Mond(),new Schokoladenteig(),new Schokolade());
        Position pos7 = new Position(1,new Weihnachtsmann(),new Muerbteig(),new Marmelade());
        Position pos8 = new Position(8,new Rund(),new Schokoladenteig());

        Bestellung best2 = new Bestellung();

        best2.addPosition(pos5);
        best2.addPosition(pos6);
        best2.addPosition(pos7);
        best2.addPosition(pos8);

        best2.drucke();
        dose2 = baeckerei.bestellen(best2);
        dose2.inhalt();
        
        System.out.println("-----------------------------------------------------");
        Keksdose dose3 = new Keksdose();

        Position pos9 = new Position(6,new Mond(),new Schokoladenteig(),new Schokolade());
        Position pos10 = new Position(5,new Weihnachtsmann(),new Muerbteig(),new Marmelade());
        Position pos11 = new Position(4,new Mond(),new Zimtsternteig());

        Bestellung best3 = new Bestellung();

        best3.addPosition(pos9);
        best3.addPosition(pos10);
        best3.addPosition(pos11);

        best3.drucke();
        dose3 = baeckerei.bestellen(best3);
        dose3.inhalt();
    }
}
