/*
Given an integer array, each element is 0-9, return the +1 array. ie: i/o: [9,9,9], output: [1,0,0,0]
*/
import java.util.*;
public class AddOne {
	public static void main(String[] args) {
		int[] input = {9, 9, 8, 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,};
		int[] result = addOne(input);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println("");
	}

	public static int[] addOne(int[] input) {
		int[] result = new int[input.length + 1];
		int carry = 1;
		for (int i = input.length - 1; i >= 0; i--) {
			int sum = carry + input[i];
			//System.out.println(sum);
			if (sum == 10) {
				result[i + 1] = 0;
				carry = 1;
			} else {
				result[i + 1] = sum;
				carry = 0;
			}
		}
		//System.out.println(carry);
		if (carry == 1) {
			result[0] = 1;
			return result;
		} else {
			int[] newResult = Arrays.copyOfRange(result, 1, result.length);

			return newResult;
		}


	}
}