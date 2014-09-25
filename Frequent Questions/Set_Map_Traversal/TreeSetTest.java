import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.*;
public class TreeSetTest {
	public static void main (String[] args) {

		TreeSetTest1();
		TreeSetTest2();
		
	}
	private static void TreeSetTest1() {
		Set<String> set = new TreeSet<String>();
    
	    set.add("a");
	    set.add("b");
	    set.add("c");
	    set.add("d");
	    set.add("e");
	    set.add("A");
	    
	    for(Iterator<String> iterator = set.iterator();iterator.hasNext();){
	      System.out.print(iterator.next()+" ");
	    }

	    System.out.println("");
	}

	private static class Comp implements Comparator<String> {
		public int compare(String one, String two) {
			return two.compareTo(one);
		}
	}
	private static void TreeSetTest2() {
		Set<String> set = new TreeSet<String>(new Comp());
		set.add("a");
	    set.add("b");
	    set.add("c");
	    set.add("d");
	    set.add("e");
	    set.add("A");

	    for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
	    	System.out.print(iterator.next() + " ");
	    }
	    System.out.println("");
	}
}