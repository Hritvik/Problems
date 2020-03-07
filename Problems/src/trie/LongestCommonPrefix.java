package trie;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<String>();
		String[] arr = { "aaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" };
		for (int i = 0; i < arr.length; i++) {
			A.add(arr[i]);
		}
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(A));
	}

	public String longestCommonPrefix(ArrayList<String> A) {
		Node root = new Node('_');
		for (int i = 0; i < A.size(); i++) {
			addToTrie(root, A.get(i), 0);
		}
		Node curr = root;
		String res = "";
		while (!curr.isLeaf && curr.next.size() == 1) {
			res += curr.v;
			curr = curr.latest;
		}
		res += curr.v;
		return res.replace("_", "");
	}

	private void addToTrie(Node root, String str, int index) {
		Node curr = root;
		for (int i = index; i < str.length(); i++) {
			char c = str.charAt(i);

			if (curr.next.containsKey(c)) {
				curr = curr.next.get(c);
			} else {
				Node temp = new Node(c);
				curr.next.put(c, temp);
				curr.latest = temp;
				curr = temp;
			}
			if (i == str.length() - 1) {
				System.out.println("leaf " + str);
				curr.isLeaf = true;
			}
		}
	}

	class Node {
		public Node(char v) {
			this.v = v;
		}

		boolean isLeaf = false;
		char v;
		Node latest = null;
		HashMap<Character, Node> next = new HashMap<Character, Node>();
	}

}
