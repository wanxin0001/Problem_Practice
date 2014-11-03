public class Gcd {
	public static int gcd(int a, int b) {
		while (a != 0 && b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}

		return a + b;
	}

	public static void main(String[] args) {
		System.out.println(gcd(33, 24));
		System.out.println(gcd(4, 82));
	}
}