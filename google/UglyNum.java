public class UglyNum {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(findUnlyNum(i));
		}

		return;
	} 
	public static int findUnlyNum(int input) {
		int product = 2 * 3 *5;
		int num = product / 2 + product / 3 + product / 5 - product / 6 - product / 15 - product / 10 + product / 30;
		int size = input / num;
		int offset = input % num;

		int offsetNum = 0;

		for (int i = 2; i <= product; i++) {
			
				if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
					offset--;
				}
				if (offset == 0) {
					offsetNum = i;
					break;
				}
			
		}

		return offsetNum + size * product;
	}
}