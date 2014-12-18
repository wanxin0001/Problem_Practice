/*
按照给定数组的顺序， A[]=5,6,10,11,15,1,2,3  output=3, 也就是 1，2，3；
*/
public class LongSeq {
	public int method(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		if (array.length == 1) {
			return 1;
		}

		int leftPtr = 0;
		int rightPtr = 0;
		int size = 1;
		while (leftPtr < array.length && rightPtr < array.length) {
			while (rightPtr + 1 < array.length && array[rightPtr + 1] == array[rightPtr] + 1) {
				rightPtr++;
			}
			size = Math.max(size, rightPtr - leftPtr + 1);
			leftPtr = rightPtr + 1;
			rightPtr++;

		}

		return size;

	}

	public static void main(String[] args) {
		int[] array = {5,6, 7, 81,0,11,15,1,2,3};
		LongSeq obj = new LongSeq();
		System.out.println(obj.method(array));
	}
}