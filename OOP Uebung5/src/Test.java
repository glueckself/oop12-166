import java.util.Iterator;

class Test {
    public static void main(String[] args) {
	Set<String> set = new Set<String>();
	set.insert("test");
    set.insert("test1");
    set.insert("test2");
    set.insert("test3");

	Iterator<String> iterator = set.iterator();

	while(iterator.hasNext()) {
	    System.out.println(iterator.next());
	}

    iterator = set.iterator();
    if(iterator.hasNext()) {
      iterator.next();
      iterator.remove();
    }

    iterator=set.iterator();
	while(iterator.hasNext()) {
	    System.out.println(iterator.next());
	}
	
	OrderedSet<Description> oSet1 = new OrderedSet<Description>();
    Description[] desc= {new Description("5blablablablabla"),
    				new Description("4blablablablabla"),
    				new Description("2blabla"),
    				new Description("6blablablablablabla"),
    				new Description("5blablablablabla")};
    
    for(Description i : desc) {
    	oSet1.insert(i);
    }
    int countRows = 0;
    Iterator<Description> oSet1Iterator = oSet1.iterator();
    while(oSet1Iterator.hasNext()) {
	    System.out.println(iterator.next()); //nicht für test notwendig
	    countRows++;
	}
    System.out.println(countRows);
    
    
    
    
    
    }
}