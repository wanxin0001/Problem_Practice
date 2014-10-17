/* 
Of the pairs of words in the dictionary that have no letters in
common, find one that maximizes the product of the words' lengths. cat
dog feed pull space pair = word1, word2 length = word1.size() *
word2.size() given a text file and a list of string, find the max
length of strings that combined from the given list of string in the
text file. Each character in the given list of string can be used only
once. 
*/

import java.util.*;
public class maxProduct {
	public static void main(String[] args) {
		String[] dict = {"cat", "doge", "feed", "pell", "space", "e", "l"};
		System.out.println(maxProduct(dict));
	}
	public static int maxProduct(String[] dict) {
		if (dict == null || dict.length <= 1) {
			return 0;
		}

		HashMap<Integer, HashSet<String>> map = new HashMap<Integer, HashSet<String>>();
		for (String word : dict) {
			if (map.containsKey(word.length())) {
				map.get(word.length()).add(word);
			} else {
				map.put(word.length(), new HashSet<String>());
				map.get(word.length()).add(word);
			}
		}

		TreeMap<Integer, ArrayList<Integer>> productTree = new TreeMap<Integer, ArrayList<Integer>>(Collections.reverseOrder());

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer item : map.keySet()) {
			list.add(item);
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				productTree.put(list.get(i) * list.get(j), new ArrayList<Integer>());
				productTree.get(list.get(i) * list.get(j)).add(list.get(i));
				productTree.get(list.get(i) * list.get(j)).add(list.get(j));
			}
		}

		for (ArrayList<Integer> pair : productTree.values()) {
			int len1 = pair.get(0);
			int len2 = pair.get(1);
			for (String word1 : map.get(len1)) {
				for (String word2 : map.get(len2)) {
					if (noCommonLetter(word1, word2)) {
						System.out.println("word1: " + word1 + " word2: " + word2);
						return len1 * len2;
					}
				}
			}
		}

		return 0;

	}

	private static boolean noCommonLetter(String word1, String word2) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < word1.length(); i++) {
			set.add(word1.charAt(i));
		}

		for (int i = 0; i < word2.length(); i++) {
			if (set.contains(word2.charAt(i))) {
				return false;
			}
		}

		return true;
	}
}