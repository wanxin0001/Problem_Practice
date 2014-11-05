import java.util.*;

public class Hops {
	public static void method(int[] input) {
		if (input == null || input.length == 0) {
			System.out.println("No Solutions");
			return;
		}

		/*
			State: f[i] means the min num to this point. If i >= array.length   make i = array.length;
			Funcition: f[i] = min(f[j] + 1) (0<= j < i, if input[j] + j >= i)
						else f[i] = 0;
			Initialize: f[0] = 0
			Answer: f[f.length -1]

			pos[i] record the loc
			
		*/

		int[] f = new int[input.length + 1];
		int[] pos = new int[input.length + 1];


		for (int i = 0; i < f.length; i ++) {
			f[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < f.length; i++) {
			if (i == 0) {
				f[i] = 0;
				pos[0] = -1;
				continue;
			} else {
				for (int j = 0; j < i; j++) {
					if (input[j] + j >= i) {
						if (f[i] > f[j] + 1) {
							f[i] = f[j] + 1;
							pos[i] = j;
						}
					}
				}
			}
		}

		if (f[f.length - 1] == Integer.MAX_VALUE) {
			System.out.println("No Solutions");
			return;
		}

		String result = "out";
		int tmp = pos[pos.length - 1];
		while (tmp != -1) {
			result = tmp + ", " + result;
			tmp = pos[tmp];
		}

		System.out.println(result);
		return;

	}

	public static void main(String[] argvs) {
		int[] input = {5, 6, 0, 4, 2, 4, 1, 0, 0, 4};
		method(input);
	}
}