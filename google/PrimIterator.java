/*
给一个list of Iterator   给一个isPrim(int a)方法  都是已知的。 写一个class implement Iterator,  跟据listOfIterator 迭代出prim
给一个已有方法boolean isPrim(int a) 判断一个数是不是质数。 再给一个List<Iterator<Integer>> 一个数字迭代器。  写一个class implement iterator 实现 hasNext()有没有下一个质数  next()下一个质数是啥
3:00 PM
*/
import java.util.*;
public class PrimIterator<T> implements Iterator<T> {
	private Iterator<T> iterator;
	
	private T nextItem;
	public PrimIterator(Iterator<T> iterator) {
		this.iterator = iterator;
	}

	public boolean hasNext() {
		if (nextItem != null) {
			return true;
		}

		while (iterator.hasNext()) {
			T tmp = iterator.next();
			if (isPrim( (Integer)tmp)) {
				nextItem = tmp;
				break;
			}
		}

		return nextItem != null;
	}

	public T next() {
		if (!hasNext()) {
			throw (new NoSuchElementException("No elements left"));
		}

		T toReturn = nextItem;
		nextItem = null;
		return toReturn;
	}

	public  static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Iterator it = list.iterator();
		PrimIterator<Integer> obj = new PrimIterator<Integer>(it);
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());

	}

	public boolean isPrim(Integer input) {
		if (input <= 1) {
			return false;
		}

		for (int i = 2; i <= input / 2; i++) {
			if (input % i == 0) {
				return false;
			}
		}

		return true;
	}
}