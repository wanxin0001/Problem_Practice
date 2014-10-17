/*
超级 prime 定义为所有前缀是 prime 的数, 比如 239 (2 , 23, 239 are all prime numbers) ,given N 打印所有长度为 N 的超级 prime
decide if a number is prime
*/

import java.util.*;
public class superPrime {
	public static void main(String[] args) {
		superPrime obj = new superPrime();
		
		System.out.println(obj.method(3));
		System.out.println(obj.method(4));
		System.out.println(obj.method(5));
		System.out.println(obj.method(6));
		System.out.println(obj.method(7));
		System.out.println(obj.method(8));

	}

	public ArrayList<Integer> method(int n) {
		HashSet<Integer> primeSet = generatePrime(n); 
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (Integer item : primeSet) {
			Integer num = item;
			if (num >= Math.pow(10, n - 1) && num < Math.pow(10, n)) {
				boolean flag = true;
				while (num / 10 != 0) {
					num = num / 10;
					if (primeSet.contains(num)) {
						continue;
					} else {
						flag = false;
						break;
					}
				}
				if (flag) {
					result.add(item);
				}
			}
		}
		return result;
	}

	private HashSet<Integer> generatePrime(int n) {
		boolean[] array = new boolean[(int)Math.pow(10, n) + 1];
		for (int i = 2; i < array.length; i++) {
			array[i] = true;
		}

		for (int i = 2; i < array.length; i++) {
			if (array[i] == true) {
				for (int j = 2 * i; j < array.length; j = j + i) {
					array[j] = false;
				}
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 2; i < array.length; i++) {
			if(array[i]) {
				set.add(i);
			}
		}

		return set;
	}


}