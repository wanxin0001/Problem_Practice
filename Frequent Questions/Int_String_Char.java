public class Int_String_Char {

	public static void main(String[] args) {
		int num = 123;
		int i = 0;
		char char3 = (char) (i + '0'); //Notice: we should have (char)
		//Error: String str = new String(num);
		String str = Integer.toString(num);
		
		
		char[] array = str.toCharArray();
		String str3 = new String(array);
		char letter = '1';
		// Error :String str4 = Char.toString(letter);
		String str4 = "" + letter;
		char letter1 = str4.charAt(0);

		int num1 = Integer.parseInt(str);
		int num2 = Integer.parseInt(letter + "");
	}
}