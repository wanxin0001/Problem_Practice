/*
Use the shorest unique prefix to represent each word in the array. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
input: ["zebra", "dog", "duck",”dot”]
output: {zebra: z, dog: do, duck: du}

[zebra, dog, duck, dove]
{zebra:z, dog: dog, duck: du, dove: dov}.鏈枃鍘熷垱鑷�1point3acres璁哄潧

[bearcat, bear]
{bearcat: bearc, bear: ""}. 1point3acres.com/bbs
*/

public class Test {
	private static class TrieNode {
		public TrieNode[] children;
		public boolean isWord;
		public int count;

		public TrieNode() {
			children = new TrieNode[26];
			for (int i = 0; i < children.length; i++) {
				children[i] = null;
			}
			isWord = false;
			count = 0;
		}
		

		public void insert(String word) {
			count++;
			if (word.length() == 0) {
				isWord = true;
				return;
			}

			char cur = word.charAt(0);
			if (children[cur - 'a'] == null){
				children[cur - 'a'] = new TrieNode();
			} 
			
			children[cur - 'a'].insert(word.substring(1));

		}

		public String minPrefix(String word) {
			if (word.length() == 0 || count == 1) {
				return "";
			}

			return "" + word.charAt(0) + children[word.charAt(0) - 'a'].minPrefix(word.substring(1));
		}
	}

	


	

	public static void main(String[] args) {
		TrieNode obj = new TrieNode();
		obj.insert("zebra");
		obj.insert("dog");
		obj.insert("duck");
		obj.insert("dot");

		System.out.println(obj.minPrefix("zebra"));
		System.out.println(obj.minPrefix("dog"));
		System.out.println(obj.minPrefix("duck"));
		System.out.println(obj.minPrefix("dot"));
	}
	
}