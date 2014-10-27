import java.util.*;

public class EvenIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private T nextItem;

	public EvenIterator(Iterator<T> iterator) {
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
			throw (new NoSuchElementException("There is no element left"));
		} 

		T retrunItem = nextItem;
		nextItem = null;
		return retrunItem;
	}

	private void advance() {
		nextItem = null;
		while (iterator.hasNext()) {
			nextItem = iterator.next();
			if ((Integer) nextItem % 2 == 0) {
				return;
			}
		}
		nextItem = null;
		return ;
	}

	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	EvenIterator<Integer> it = new EvenIterator<Integer>(list.iterator());
    	System.out.println(it.next());
    	
    	System.out.println(it.next());
    	try {
    		System.out.println(it.next());
    	} catch(Exception exc) {
    		//System.out.println("");
    	}
	}
}