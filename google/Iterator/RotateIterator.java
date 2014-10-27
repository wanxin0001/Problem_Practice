import java.util.*;

public class RotateIterator<T> implements Iterator<T> {
	private final List<Iterator<T>> iteratorList;
	private T nextItem;
	private int nextPos;

	public RotateIterator(List<Iterator<T>> iteratorList) {
		this.iteratorList = new ArrayList<Iterator<T>>(); //Notice
		for (Iterator<T> iterator : iteratorList) {
			this.iteratorList.add(iterator); //Notice
		}

		nextPos = 0;
	}

	public boolean hasNext() {
		if (nextItem != null) {
			return true;
		}
		for (int i = 0; i < iteratorList.size(); i++) {
			int cur = (i + nextPos) % iteratorList.size(); //Very Important!!!
			if (iteratorList.get(cur).hasNext()) {
				nextItem = iteratorList.get(cur).next();
				nextPos = cur + 1;
				return true;
			}
		}

		return false;
	}

	public T next() {
		if (hasNext() == false) {
			throw (new NoSuchElementException("There is no left any elements"));
		} 

		T returnItem = nextItem;
		nextItem = null;
		return returnItem;
	}


	public static void main(String[] args) throws Exception {

		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list1.add(4);
    	list1.add(5);
    	list1.add(6);
    	list2.add(7);
    	list2.add(8);
    	//ArrayList<ArrayList<Integer>> collection = new ArrayList<ArrayList<Integer>>();
    	
    	Iterator<Integer> it1 = list.iterator();
    	Iterator<Integer> it2 = list1.iterator();
    	Iterator<Integer> it3 = list2.iterator();
    	List<Iterator<Integer>> collection = new ArrayList<Iterator<Integer>>();

    	collection.add(it1);
    	collection.add(it2);
    	collection.add(it3);

    	RotateIterator<Integer> it = new RotateIterator<Integer>(collection);
    	while (it.hasNext()) {
    		System.out.println(it.next());
    	}

    	return;
	}
}