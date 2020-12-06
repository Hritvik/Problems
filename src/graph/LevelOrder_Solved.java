package graph;

import java.util.ArrayList;
import java.util.TreeMap;

public class LevelOrder_Solved {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {

	}

	private void inorder(TreeNode A, TreeMap<Integer, ArrayList<Integer>> map, int level) {
		if (A != null) {
			inorder(A.left, map, level + 1);
			ArrayList<Integer> list = null;
			if (map.containsKey(level)) {
				list = map.get(level);
			} else {
				list = new ArrayList<Integer>();
			}
			list.add(A.val);
			map.put(level, list);
			inorder(A.right, map, level + 1);
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		inorder(A, map, 0);
		for (int key : map.keySet()) {
			result.add(map.get(key));
		}
		return result;

	}

}
