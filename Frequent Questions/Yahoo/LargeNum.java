public class LargeNum {
	public int multiply(int first, int second) {
		int isNeg = (first < 0 && second > 0 || first > 0 && second < 0) ? -1 : 1;
		long a = first > 0 ? (long) first : (long) (-first);
		long b = second > 0 ? (long) second : (long) (-second);

		long result = 0;
		while (b > 0) {
			int shift = 0; 
			while (b >= (1 << shift)) {
				shift++;
			}
			//
			result += add(a, shift - 1);
			//System.out.println(result);
			b = b - (1 << (shift - 1));
		} 
		//
		result *= isNeg;

		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else {
			return (int) result;
		}
	}

	private long add (long a, int shift) {
		if (shift == 0) {
			return a;
		} 

	
		return add(a + a, shift - 1);
	}

	public static void main(String[] args) {
		LargeNum obj = new LargeNum();
		System.out.println(obj.multiply(1, 5));
		System.out.println(obj.multiply(99, 99));
		System.out.println(obj.multiply(99, -99));

		System.out.println(obj.divide(10, 4));
		System.out.println(obj.divide(100, 4));
		System.out.println(obj.divide(1, 4));
		System.out.println(obj.divide(-10, 4));
		System.out.println(obj.divide(100, -4));
	}


	public int divide(int first, int second) {
		int isNeg = (first > 0 && second < 0 || first < 0 && second > 0) ? -1 : 1;
		long a = (long) Math.abs(first);
		long b = (long) Math.abs(second);

		int result = 0;
		while (a >= b) {
			int shift = 0;
			long tmp = b;
			//long last = tmp;
			while (a >= tmp) {
				shift++;
				//last = tmp;
				tmp += tmp;
				
			}

			result += add(1, shift - 1);
			a -= add(b, shift - 1);
		}

		result *= isNeg;

		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else {
			return (int) result;
		}
	}
}