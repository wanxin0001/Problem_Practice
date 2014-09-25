import java.util.*;
public class HashSet_Traversal {
	public static void main (String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("f");
		set.add("a");
	    set.add("b");
	    set.add("c");
	    set.add("d");
	    set.add("e");
	    
	    set.add("e");

	    for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
	    	System.out.print(iterator.next() + " ");
	    }

	    System.out.println();
	    System.out.println("*********************");

	    for (String val : set) {
	    	System.out.print(val + " ");
	    }
	}
}