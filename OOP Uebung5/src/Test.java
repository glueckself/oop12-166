import java.util.Iterator;

class Test {
    public static void main(String[] args) {
	OrderedSet<Description> oSet1 = new OrderedSet<Description>();
	Description[] desc= {new Description("1x"),
				    new Description("2xx"),
				    new Description("2xx"),
				    new Description("1x"),
				    new Description("1x"),
				    new Description("7xxxxxxx"),
				    new Description("4xxxx"),
				    new Description("10xxxxxxxxxx"),
				    new Description("6xxxxxx")};
	
	for(Description i : desc) {
	    oSet1.insert(i);
	}

	int countRows = 0;
	Iterator<Description> oSet1Iterator = oSet1.iterator();
	while(oSet1Iterator.hasNext()) {
	    System.out.println(oSet1Iterator.next()); //nicht für test notwendig
	    countRows++;
	}
	System.out.println(countRows);
    }
}
