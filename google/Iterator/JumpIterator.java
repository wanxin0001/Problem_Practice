import java.util.*;

public class JumpIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private T nextItem;
	
	public JumpIterator(Iterator<T> iterator) {
		this.iterator = iterator;
	}

	public boolean hasNext() {
		if (nextItem != null) {
			return true;
		}

		advance();
		return nextItem != null;
	}

	public T next() {
		if (hasNext() == false) {
			throw (new NoSuchElementException("There is no such element left!"));
		}

		T returnItem = nextItem;
		nextItem = null;
		return returnItem;
	}

	private void advance() {
		if (iterator.hasNext()) {
			nextItem = iterator.next();
			if (iterator.hasNext()) {
				nextItem = iterator.next();
				return;
			} 
		}
		nextItem = null;
		return;
	}

	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);

    	ArrayList<Integer> list1 = new ArrayList<Integer>();
    	list1.add(1);
    	list1.add(2);
    	list1.add(3);

    	JumpIterator<Integer> it = new JumpIterator<Integer>(list.iterator());
    	JumpIterator<Integer> it1 = new JumpIterator<Integer>(list.iterator());
    	System.out.println(it.next());
    	
    	System.out.println(it.next());
    	try {
    		System.out.println(it.next());
    		//System.out.println(it1.next());
    		//System.out.println(it1.next());
    	} catch(Exception exc) {
    		//System.out.println("");
    	}
    	try {
    		//System.out.println(it.next());
    		System.out.println(it1.next());
    		System.out.println(it1.next());
    	} catch(Exception exc) {
    		//System.out.println("");
    	}
	}
}