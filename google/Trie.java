public class Trie {
	public static void main(String[] argv) {
		Trie root = new Trie();
		root.insert("zebra");
		root.insert("dog");
		root.insert("duck");
		root.insert("dot");

		System.out.println(root.minPrefix("zebra"));
		System.out.println(root.minPrefix("dog"));
		System.out.println(root.minPrefix("duck"));
		System.out.println(root.minPrefix("dot"));
	}

	
	private	boolean isWord;
	private	int count;
	private Trie[] children;

	public Trie() {
			isWord = false;
			count = 0;
			children = new Trie[26];
			for (Trie child : children) {
				child = null;
			}
		
 	}

 	public void insert(String word) {
 		count++;
 		if (word.length() == 0) {
 			isWord = true;
 			return;
 		} 

 		int tmp = word.charAt(0) - 'a';
 		if (children[tmp] == null) {
 			children[tmp] = new Trie();
 		}
 		children[tmp].insert(word.substring(1));
 		return;
 	}

 	public String minPrefix(String word) {
 		if (word.length() == 0 || count == 1) {
 			return "";
 		}

 		String result = "";
 		return "" + word.charAt(0) + children[word.charAt(0) - 'a'].minPrefix(word.substring(1));
 	}

}