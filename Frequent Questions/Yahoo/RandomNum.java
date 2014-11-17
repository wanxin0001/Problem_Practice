import java.util.*;
public class RandomNum {
	public static int method(int n) {
		Random rand = new Random();
		int shift = 0;
		while ((1 << shift) <= n) {
			shift++;
		}
		
		
		int result = 0;
		for (int i = 0; i < shift; i++) {
			result +=  rand.nextInt(2) << i;

			if (result > n ) {
				i = -1;
				result = 0;
			}

			if (i == shift - 1 && result == 0) {
				i = -1;
				result = 0;
			}

		}

		return result;
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10000000; i++) {
			
			int cur = method(10);
			if (map.containsKey(cur)) {
				map.put(cur, map.get(cur) + 1);
			} else {
				map.put(cur, 1);
			}

		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	} 
}