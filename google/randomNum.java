/*
有 k 个数,排好序的,这些数都是 0 到 N 间的,写一个 randomnumber generate 来 generate 一个 0-N 间的数且不能是 k 里面的。
*/

public class randomNum {
	public int random(int[] input) {
		Random randGenerator = new Random();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			map.put(input[i], i + 1);
		}
	}
}