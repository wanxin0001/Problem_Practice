public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(FibonacciMethod(0));
		System.out.println(FibonacciMethod(1));
		System.out.println(FibonacciMethod(2));

		System.out.println(FibonacciMethod(3));
		System.out.println(FibonacciMethod(4));

	}

	private static int FibonacciMethod(int num) {
		if (num  < 0) {
			return -1;
		}

		int prev_prev = 0;
		int prev = 1;

		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		}
		for (int i = 2; i <= num; i++) {
			int tmp = prev_prev + prev;
			prev_prev = prev;
			prev = tmp;

		}

		return prev;
	}

}