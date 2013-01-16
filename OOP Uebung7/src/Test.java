
public class Test {
    public static void main(String argv[]) {
        Carriageway teststrecke;
        Player car1, car2, car3, car4;
        
        teststrecke = new Carriageway(8,6);
        car1 = new Car("auto 1", new RandomMovement(),new FastEngine());
        car2 = new Car("auto 2", new CircleMovement(3,true),new FastEngine());
        car3 = new Car("auto 3", new CircleMovement(7,false), new AgileEngine());
        car4 = new Car("auto 4", new RandomMovement(),new AgileEngine());
        teststrecke.addPlayer(3,4, car4);
        teststrecke.addPlayer(1,3, car1);
        teststrecke.addPlayer(7,2, car2);
        teststrecke.addPlayer(7,5, car3);
        
        try {
            Thread.sleep(3000);
            System.out.print("Time out");
        } catch (InterruptedException ex) {
            System.out.print("A player has finished");
        } finally {
            System.out.println(", ending game...");
            teststrecke.endGame();
        }
        
    }
}
