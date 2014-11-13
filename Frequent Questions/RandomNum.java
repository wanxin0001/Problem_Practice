/*
第二轮：
int returnRandomNumber(int max, vector<int> &bad_numbers){
}
返回0-max之间的随机数，不能包含bad_numbers之中的数。bad_numbers是排好序的。
*/
import java.util.*;
public class RandomNum {
	public static void main(String[] args) {
		RandomNum obj = new RandomNum();
		int[] badNum = {3, 6, 9};
		for (int i = 0; i < 100; i++) {
			System.out.println(obj.returnRandomNumber(10, badNum));
		}
	}

	public int returnRandomNumber(int max, int[] badNum) {
		Random rand = new Random();
		int[] tmp = new int[badNum.length];

		for (int i = 0; i < badNum.length; i++) {
			tmp[i] = badNum[i] - i;
		}

		int num = rand.nextInt(max - badNum.length) + 1;

		int size = binarySearch(tmp, num);

		return num + size;
	}

	private int binarySearch(int[] input, int num) {
		int left = 0;
		int right = input.length - 1;

		while (left < right  - 1) {
			int mid = left + (right - left) / 2;
			if (input[mid] == num) {
				return mid + 1;
			} else if (input[mid] > num) {
				right = mid;
			} else {
				left = mid;
			}
		}

		if (input[left] == num) {
			return left + 1;
		} 

		if (input[right] == num) {
			return right + 1;
		}

		if (input[right] < num) {
			return right  + 1;
		}


		if (input[left] < num) {
			return left  + 1;
		}

		return 0;


	}
}