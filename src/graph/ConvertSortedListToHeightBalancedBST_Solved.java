package graph;

import java.util.ArrayList;

public class ConvertSortedListToHeightBalancedBST_Solved {
//height balanced BST.
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(4);
		list.add(8);
		list.add(12);
		ConvertSortedListToHeightBalancedBST_Solved balancedBST = new ConvertSortedListToHeightBalancedBST_Solved();
		TreeNode root = balancedBST.recursive(list, 0, list.size() - 1);
		balancedBST.inorder(root);
		System.out.println();
		System.out.println("root = " + root.val);
		balancedBST.printTree(root);
	}

	private TreeNode sortedListToBST(ListNode a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (a != null) {
			list.add(a.val);
			a = a.next;
		}

		TreeNode root = recursive(list, 0, list.size()-1);

		return root;
	}

	private void printTree(TreeNode root) {
		if (root != null) {
			printTree(root.left);
			String l = "-";
			String r = "-";
			if (root.left != null) {
				l = ""+root.left.val;
			}
			if (root.right != null) {
				r = ""+root.right.val;
			}
			System.out.print(root.val + "[" + l + "," + r + "]" + " -> ");
			printTree(root.right);
		}

	}

	private void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + " -> ");
			inorder(root.right);
		}
	}

	private TreeNode recursive(ArrayList<Integer> list, int start, int end) {
		TreeNode root = null;
		int mid = 0;
//		System.out.println("[" + start + ", " + end + "]");
//		System.out.println("[" + list.get(start) + ", " + list.get(end) + "]");
		if (end == start) {
			root = new TreeNode(list.get(start));
		} else if (end - start == 1) {
			root = new TreeNode(list.get(end));
			TreeNode left = new TreeNode(list.get(start));
			root.left = left;
		} else {
			if ((end - start) % 2 == 0) {
				mid = (end + start) / 2;
			} else {
				mid = (end + start + 1) / 2;
			}

			root = new TreeNode(list.get(mid));			
			root.left = recursive(list, start, mid - 1);
			root.right = recursive(list, mid + 1, end);
		}
		return root;
	}
}
