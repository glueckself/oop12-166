
class Test {

    public static void main(String[] args) {
        Position pos1 = new Position(5,new Rund(),new Muerbteig());
        Bestellung best1 = new Bestellung();
        best1.addPosition(pos1);
        best1.drucke();

    }

}
