import java.util.*;

public class PeekIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private T nextItem;

	public PeekIterator(Iterator<T> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		if (nextItem != null) {
			return true;
		}

		if (iterator.hasNext()) {
			nextItem = iterator.next();
		}

		return nextItem != null;
	}

	public T next() {
		if (!hasNext()) {
			throw (new NoSuchElementException("Iterator has no elements left."));
		}

		T returnItem = nextItem;
		nextItem = null;

		return returnItem;
	}

	public T peek() {
		if (!hasNext()) {
			throw (new NoSuchElementException("Iterator has no elements left."));
		}

		return nextItem;
	}

	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		PeekIterator<Integer> it = new PeekIterator<Integer>(list.iterator());
		System.out.println(it.peek());
    	it.next();
    	System.out.println(it.peek());
	}
}