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
    }
}
