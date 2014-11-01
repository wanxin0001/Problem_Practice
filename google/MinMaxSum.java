/*
1. 一串数，例如 10， 20，30，40，20，50，25. 两个玩家，只能选最左或最右，轮流选，怎样max你的和。举出贪心反例。用max-min。
*/
public class MinMaxSum {
	public static int compute(int[] input) {
		int[][] f = new int[input.length][input.length];
		int a, b, c;
		int len = input.length;
		for (int i = 0; i < len; i++) {
			for (int m = 0, n = i; n < len; m++, n++) {
				
				a = (m + 2 <= len - 1) ? f[m + 2][n] : 0;
				b = (m + 1 <= len - 1 && n - 1 >= 0) ? f[m + 1][n - 1] : 0;
				c = (n - 2 >= 0) ? f[m][n - 2] : 0;

				f[m][n] = Math.max(input[m] + Math.min(a, b), input[n] + Math.min(b, c)); 
			}
		}

		return f[0][len - 1];
	} 

	public static void main(String[] args) {
		int[] input = {10, 20, 30, 40, 20, 50, 25};
		System.out.println(compute(input));
	}
}