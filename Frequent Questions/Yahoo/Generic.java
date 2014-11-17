import java.util.*;
public class Generic<K, V> extends HashMap {
	private Map<K, V> map = new HashMap<K, V>();
	public Generic() {
		//map = new HashMap<K, V>();

	}

	public void put(K key, V value) {
		map.put( key, value);
	}

	public V get(K key) {
		return map.get(k);
	}

	public V getMinValue() {
		V min = null; 
		for (V val : map.values()) {
			if (min == null) {
				min = val;
			} else {
				if (min.compareTo(val) == 1) {
					min = val;
				}
			}
		}

		return min;
	}

	public V getMaxValue() {
		V max = null;
		for (V val : map.values()) {
			if (max == null) {
				max = val;
			} else {
				if (max.compareTo(val) == -1) {
					max = val;
				}
			}
		}

		return V;
	}

	public static void main(String[] args) {
		Generic<Integer> obj = new Generic<Inetger>();
		obj.put(1, 10);
		obj.put(2, 20);
		System.out.println(obj.getMinValue());
		System.out.println(obj.getMaxValue());
	}

}