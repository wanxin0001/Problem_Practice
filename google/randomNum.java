/*
有 k 个数,排好序的,这些数都是 0 到 N 间的,写一个 randomnumber generate 来 generate 一个 0-N 间的数且不能是 k 里面的。
*/
import java.util.*;
public class randomNum {
	public static void main(String[] args) {
		randomNum obj = new randomNum();
		int[] input = {1, 2 ,3};
		System.out.println(obj.random(input, 5));
		System.out.println(obj.random(input, 5));
		System.out.println(obj.random(input, 5));
		System.out.println(obj.random(input, 5));
		System.out.println(obj.random(input, 5));
		System.out.println(obj.random(input, 5));
		System.out.println(obj.random(input, 5));
		System.out.println(obj.random(input, 5));


	}

	public int random(int[] input, int N) {
		Random randGenerator = new Random();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : input) {
			set.add(num);
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (!set.contains(i)) {
				map.put(idx, i);
				idx++;
			} 


		}

		int randomInt = randGenerator.nextInt(N - input.length);
		return map.get(randomInt);
	}
}