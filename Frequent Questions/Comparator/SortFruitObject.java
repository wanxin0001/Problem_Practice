import java.util.*;
public class SortFruitObject {
	public static void main(String args[]){
 
		Fruit[] fruits = new Fruit[4];
 
		Fruit pineappale = new Fruit("Pineapple", "Pineapple description",70); 
		Fruit apple = new Fruit("Apple", "Apple description",100); 
		Fruit orange = new Fruit("Orange", "Orange description",80); 
		Fruit banana = new Fruit("Banana", "Banana description",90); 
 
		fruits[0]=pineappale;
		fruits[1]=apple;
		fruits[2]=orange;
		fruits[3]=banana;
 
		Arrays.sort(fruits);
 
		int i=0;
		for(Fruit temp: fruits){
		   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
			", Quantity : " + temp.getQuantity());
		}

		Fruit[] array = getTopKElements(fruits, 2);

		i = 0;
		for(Fruit temp: array){
		   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
			", Quantity : " + temp.getQuantity());
		}
 	

	}

	private static Fruit[] getTopKElements(Fruit[] fruits, int k) {
		FruitsComparator comp = new FruitsComparator();
		PriorityQueue<Fruit> heap = new PriorityQueue<Fruit>(k, comp);
		for (int i = 0; i < fruits.length; i++) {
			if (i < k) {
				heap.add(fruits[i]);
			} else {
				if (fruits[i].getQuantity() > ((Fruit) heap.peek()).getQuantity() ) {
					heap.poll();
					heap.add(fruits[i]);
				}
			}
		}

		Fruit[] result = new Fruit[k];
		for (int i = 0; i < k; i++) {
			result[i] = (Fruit)heap.poll();
		}

		return result;
	}

	private static class FruitsComparator implements Comparator<Fruit> {
		public int compare(Fruit one, Fruit two) {
			return one.getQuantity()- two.getQuantity();
		}
	}
}