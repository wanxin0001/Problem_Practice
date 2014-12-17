/*
有一个bag类，里面有三种方法，一种是insert一个ball，一个是remove一个ball，还有一个就是random remove一个ball。你要设计一个data structure来实现三种方法，要求是constant time的。后来面完在网上查了一下是有这道题的面经的。
10:33

*/

import java.util.*;

public class RandomDS {
	private static class Bag {
		public int val;
		public Bag (int val) {
			this.val = val;
		}
	}
	private HashMap<Bag, Integer> map = new HashMap<Bag, Integer>();
	private Bag[] array = new Bag[10];
	private int size = 0;

	public void insert(Bag bag) {
		size++;
		map.put(bag, size - 1);
		array[size - 1] = bag;
		print();
		return;
	}

	public void remove(Bag bag) {
		int index = map.get(bag);
		array[index] = array[size - 1];
		size--;
		map.remove(bag);
		map.put(array[index], index);
		print();
		return;
	}

	public void randomRemove() {
		Random rand = new Random();
		int index = rand.nextInt(size);
		remove(array[index]);
		print();
		return;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i].val + " ");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		RandomDS obj = new RandomDS();
		Bag bag1 = new Bag(1);
		Bag bag2 = new Bag(2);
		Bag bag3 = new Bag(3);

		obj.insert(bag1);
		obj.insert(bag2);
		obj.insert(bag3);

		obj.remove(bag1);
		obj.remove(bag3);
		obj.randomRemove();
	}


}