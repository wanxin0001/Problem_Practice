import java.util.*;
public class Solution {
	public static void main(String[] args) {
		HashMap<ArrayList<Integer>, Integer> map = new HashMap<ArrayList<Integer>, Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);

		list2.add(1);
		list2.add(2);

		Integer[] array = {1, 2};
		ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(array));

		if (map.containsKey(list1)) {
			map.put(list1, map.get(list1) + 1);
		} else {
			map.put(list1, 1);
		}

		if (map.containsKey(list2)) {
			map.put(list2, map.get(list2) + 1);
		} else {
			map.put(list2, 1);
		}

		if (map.containsKey(list3)) {
			map.put(list3, map.get(list3) + 1);
		} else {
			map.put(list3, 1);
		}

		System.out.println(map);
	}
}