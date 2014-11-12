/*
有这么个游戏，举个例子：给你5个空_ _ _ _ _, 每次猜一个字母，这里出题人想让你猜出来clock，假如你猜a，告诉你这里面没有。你又猜c，他把c全写出来，所以你有c _ _ c _。 让你最多猜10次。写一个程序去猜。输入是几个空，要考虑每次猜的反馈，尽量把词猜出来。
*/
import java.util.*;

public class GuessWord {

	public boolean method(String word, HashSet<String> dict) {
		HashMap<Integer, HashSet<String>> map = new HashMap<Integer, HashSet<String>>();
		for (String word : dict) {
			if (!map.containsKey(word.length())) {
				map.put(word.length(), new HashSet<String>());
			}
			map.get(word.length()).add(word);
		}

		HashSet<String> wordSet = new HashSet<String>(map.get(word.length()));
		HashMap<Character, HashSet<String>> letter2words = new HashMap<Character, HashSet<String>>();

		for (String word : wordSet) {
			for (int i = 0; i < word.length(); i++) {
				if (!letter2words.containsKey(word.charAt(i))) {
					letter2words.put(word.charAt(i));
				}
				letter2words.get(word.charAt(i)).add(word);
			}
	
		}

		PriorityQueue<Character> queue = new PriorityQueue<Character>(26, new comp());
		for (Map.Entry<String, HashSet<String>> entry : letter2words.entrySet()) {
			queue.offer(entry);
		}

		HashMap<Character, Integer> wordMap = new HashMap<Character, Integer>();
		for (int i = 0; i < word.length(); i++) {
			if (wordMap.containsKey(word.charAt(i))) {
				wordMap.put(word.charAt(i), wordMap.get(word.charAt(i)) + 1);
			} else {
				wordMap.put(word.charAt(i), 1);
			}
		}



		char[] array = word.toCharArray();
		int len = array.length;
		for (int i = 0; i < 10; i++) {
			char curLetter = queue.poll();
			if (wordMap.containsKey(curLetter)) {
				for (int j = 0; j < word.length(); j++) {
					ArrayList<Integer> idxSet = new ArrayList<Integer>();
					HashSet<String> tmp = new HashSet<String>();
					if (word.charAt(j) == curLetter) {
						idxSet.add(j);

					}
				}

				len = len - idxSet.size();
				for (String word : wordSet) {
					for (Integer idx : idxSet) {
						if (word.charAt(idx) != curLetter) {
							continue;
						}
						tmp.add(word);
					}
				}

				

				wordSet = new HashSet<String>(tmp);
			} else {
				s
			}
		}

		

	}


	private static class comp implements Comparator<Map.Entry<String, HashSet<String>>> {
		int compare(MMap.Entry<String, HashSet<String>> a, Map.Entry<Stirng, HashSet<String>> b) {
			return a.getValue().size() - b.getValue().size();
		}
	}
	
}