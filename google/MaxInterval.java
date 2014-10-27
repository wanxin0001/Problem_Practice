/*
给一个未排序的数组A[]，自己定义一个Y使得Y在数组(min，max)之间，然后想要max min|Ai - Y|
就比如给一个数组[2,1,3,100], 需要Y在[1,100]之间，比如取Y为53，那么min |Ai - Y| 就是100-53=47； 如果Y取51，那么min |Ai - Y| 就是 51-3 = 48; 48比47大并且是可能取到的 min |Ai - Y| 的最大值，则返回48
排序，然后比较相邻两个数

public int maxMinDiff(int[] A) {
        if (A == null || A.length == 0) {
            return -1; 
        }
        Arrays.sort(A); 
        int diff = Integer.MIN_VALUE; 
        for (int i = 1; i < A.length; ++i) {
            if (A[i] - A[i - 1] > diff) {
                diff = A[i] - A[i - 1]; 
            }
        }
        
        return diff / 2; 
}
*/
import java.util.*;
public class MaxInterval {
	public static void main(String[] args) {
		int[] A = {1, 3, 2, 100};
		int[] B = {Integer.MIN_VALUE, Integer.MAX_VALUE};
		MaxInterval obj = new MaxInterval();
		System.out.println(obj.MaxInterval(A));
		System.out.println(obj.MaxInterval(B));
	}
	public int MaxInterval (int[] A) {
		if (A == null || A.length <= 1) {
			return -1;
		}

		Arrays.sort(A);
		long diff = (long) Integer.MIN_VALUE;
		int pos = 0;
		for (int i = 0; i < A.length - 1; i++) {
			long temp = (long) A[i + 1] - (long)A[i];

			
			if (diff < temp) {
				diff = temp;
				pos = i;
			}

		}

		return A[pos] + (int) (diff / 2);
	}
}