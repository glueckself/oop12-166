import java.util.Iterator;

class Test {
    public static void main(String[] args) {
	Set<String> set = new Set<String>();
	set.insert("test");
	Iterator<String> iterator = set.iterator();

	while(iterator.hasNext()) {
	    System.out.println(iterator.next());
	}
    }
}
