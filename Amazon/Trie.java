public class Trie {
	private Trie[] elements;
	private boolean isWord;
	private int count;

	public Trie() {
		elements = new Trie[26];
		isWord = false;
		count = 0;
		for (int i = 0; i < 26; i++) {
			this.elements[i] = null;
		}
	}

	public void add(String word) {
		count++;
		if (word.length() == 0) {
			isWord = true;
			return;
		}
		if (this.elements[word.charAt(0) - 'a'] == null) {
			this.elements[word.charAt(0) - 'a'] = new Trie();
		} 
		
		this.elements[word.charAt(0) - 'a'].add(word.substring(1));
	}

	public boolean search(String word) {
		if (word.length() == 0) {
			return isWord == true;
		}

		if (elements[word.charAt(0) - 'a'] == null) {
			return false;
		}

		return elements[word.charAt(0) - 'a'].search(word.substring(1));
	}

	public static void main(String[] args) {
		Trie obj = new Trie();
		obj.add("apple");
		obj.add("amazon");
		obj.add("amml");
		obj.add("yahoo");
		System.out.println(obj.search("apple"));
		System.out.println(obj.search("yahoo"));
		System.out.println(obj.search("google"));
		System.out.println(obj.print("apple"));
		System.out.println(obj.print("amazon"));
		System.out.println(obj.print("amm"));
	}

	public String print(String word) {
		if (count == 1 || word.length() == 0) {
			return "";
		}

		return word.substring(0, 1) + elements[word.charAt(0) - 'a'].print(word.substring(1));
	}
}