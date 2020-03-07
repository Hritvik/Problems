package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LargestDistanceBetweenNodesOfATree {
	static int maxPathLength = 0;

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();

//		int[] arr = { -1, 0, 0, 0, 3 };

		int[] arr = { -1, 0, 0, 1, 0, 4, 5, 5, 5, 6, 8, 7, 10, 2, 2, 1, 12, 6, 13, 1, 16, 1, 2, 14, 5, 7, 13, 18, 26,
				24, 16, 3, 21, 7, 3, 0, 32, 13, 19, 13, 1, 25, 38, 32, 3, 41, 13, 6, 14, 12, 38, 20, 13, 19, 5, 4, 22,
				9, 21, 9, 55, 53, 61, 0, 55, 27, 20, 11, 51, 50, 48, 53, 42, 9, 48, 17, 38, 27, 0, 36, 51, 26, 33, 5,
				22, 67, 15, 78, 28, 65, 69, 14, 24, 28, 9, 27, 18, 59, 28, 40 };

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		System.out.println(new LargestDistanceBetweenNodesOfATree().solve(list));
	}

	class Tree {
		int data;
		Tree p;
		int height = -1;
		int[] height_array;
		ArrayList<Tree> children;
		int maxPathLengthGoingThroughThisNode;

		Tree(int data) {
			this.data = data;
			children = new ArrayList<Tree>();
		}

		@Override
		public String toString() {
			String str = data + "{" + height + "}[";
			for (int i = 0; i < children.size(); i++) {
				Tree child = children.get(i);
				str += child.toString() + ",";
			}
			str = str.substring(0, str.length() - 1);
			if (!str.endsWith("[")) {
				str += "]";
			}
			return str;
		}
	}

	public int solve(ArrayList<Integer> p_arr) {
		HashMap<Integer, Tree> map = new HashMap<Integer, Tree>();
		Tree root = null;
		for (int i = 0; i < p_arr.size(); i++) {
			Tree t = new Tree(i);
			int p_i = p_arr.get(i);
			if (p_i == -1) {
				root = t;
			}
			map.put(i, t);
			Tree p = null;
			if (map.containsKey(p_i)) {
				p = map.get(p_i);
			} else {
				p = new Tree(p_i);
			}
			t.p = p;
			p.children.add(t);
		}
		findHights(root);
//		System.out.println(root.toString());
		return maxPathLength;
	}

	private void findHightsIterative(Tree root) {
		Queue<Tree> q = new LinkedList<Tree>();
		q.add(root);
		while(!q.isEmpty()) {
			
		}
	}

	private void findHights(Tree root) {
		if (root != null) {
			ArrayList<Tree> children = root.children;
			if (!children.isEmpty()) {
				int maxLength = -1;
				int nextMaxLength = -1;
				for (int i = 0; i < children.size(); i++) {
					Tree child = children.get(i);
					findHights(child);
					if (child.height >= maxLength) {
						nextMaxLength = maxLength;
						maxLength = child.height;
					} else if (child.height >= nextMaxLength) {
						nextMaxLength = child.height;
					}
				}
				root.height = maxLength + 1;
				root.maxPathLengthGoingThroughThisNode = 2 + maxLength + nextMaxLength;
				if (maxPathLength < root.maxPathLengthGoingThroughThisNode) {
					maxPathLength = root.maxPathLengthGoingThroughThisNode;
				}
			} else {
				root.height = 0;
			}
		}
	}
}
