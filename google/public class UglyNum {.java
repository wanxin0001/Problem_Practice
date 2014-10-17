public class UglyNum {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(findUnlyNum(i));
		}

		return;
	} 
	public int findUnlyNum(int input) {
		int product = 2 * 3 *5;
		int num = product / 2 + product / 3 + product / 5 - product / 6 - product / 15 - product / 10 + product / 30;
		int size = input / num;
		int offset = input % num;

		int offsetNum = 2;
		for (int i = 0; i < offset; i++) {
			while (1) {
				if (offsetNum % 2 == 0 || offsetNum % 3 == 0 || offsetNum % 5 == 0) {
					break;
				}
				offsetNum++;
			}
		}

		return offsetNum + size * product;
	}
}