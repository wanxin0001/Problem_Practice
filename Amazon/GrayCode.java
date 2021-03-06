public class GrayCode {
	public static void main(String[] argv) {
		System.out.println(grayCode((byte)0x08, (byte)0x09));
		System.out.println(grayCode((byte)0x01, (byte)0x02));
	}

	public static int grayCode(byte term1, byte term2) {
		int result = term1 ^ term2;
		int count = 0;
		int ch = 0x01;
		for (int i = 0; i < 8; i++) {
			if ((result & ch) != 0) {
				count++;
			}
			ch = ch << 1;
		}

		return count == 1 ? 1 : 0;
	}
}