public class MaxArithSeq {
	public static void main(String[] args) {
		int[] input = {-1, 3, 4, 6, 9, 12, 15};
		int[] input1 = {-1, 3, 4 , 6, 9, 12, 15, 12 ,9, 6, 3 };
		System.out.println(method(input));
		System.out.println(method(input1));

	}

	private static int method(int[] input) {
		if (input.length <= 1) {
			return input.length;
		}

		int maxLen = 1;
		int last = input[0]; //-1
		int tmpSize = 1;
		for (int i = 1; i < input.length; i++) {  //1 2 3
			//System.out.println(i + " " + last);
			int diff = input[i] - last; //4 1 2  3
			tmpSize = 1; //1
			while (i < input.length && input[i] - input[i - 1] == diff) {
				//System.out.println(diff + " " + input[i] +" " + input[i - 1]);
				tmpSize++; //2
				i++; // 2 3 4
			}

			maxLen = Math.max(maxLen, tmpSize); //2
			tmpSize = 1; //1
			last = input[i - 1]; //3 4 6
			i--;
		}

		
		return maxLen;
	}
}