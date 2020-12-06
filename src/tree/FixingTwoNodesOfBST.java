package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int data;
	Node left, right;

	Node(int key) {
		data = key;
		left = right = null;
	}
}

class FixingTwoNodesOfBST {
	static int flag = 1;
	static int c = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int m = n;
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Node root = null;
			Node temp = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int a1 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (i == 0) {
					root = new Node(a);
					temp = new Node(a);
					switch (lr) {
					case 'L':
						root.left = new Node(a1);
						temp.left = new Node(a1);
						break;
					case 'R':
						root.right = new Node(a1);
						temp.right = new Node(a1);
						break;
					}
				} else {
					insert(root, a, a1, lr);
					insert(temp, a, a1, lr);
				}
			}
			flag = 1;
			c = 0;
			GFG gfg = new GFG();
			root = gfg.correctBST(root);

			inorder(temp, root);
			if (c + 1 == m)
				System.out.println(flag);
			else
				System.out.println("0");

		}
	}

	public static void insert(Node root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Node(a1);
				break;
			case 'R':
				root.right = new Node(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

	public static void inorder(Node temp, Node root) {
		if (flag == 0) {
			return;
		}
		if (temp == null && root == null)
			return;
		if (root == null) {
			flag = 0;
			return;
		}
		if (temp == null) {
			flag = 0;
			return;
		}
		if (temp.data == root.data) {
			c++;
		}
		inorder(temp.left, root.left);
		inorder(temp.right, root.right);
	}
}

class GFG {
	Node A;
	Node B;

	public Node correctBST(Node root) {
		recursive(root, -Integer.MAX_VALUE, Integer.MAX_VALUE);
//		if (A != null) {
//			System.out.println("A :: " + A.data);
//		}
//		if (B != null) {
//			System.out.println("B :: " + B.data);
//		}
		if (A != null && B != null) {
			int temp = A.data;
			A.data = B.data;
			B.data = temp;
		}
		return root;
	}

	private void recursive(Node root, int lowerLimit, int upperLimit) {
//		System.out.println(lowerLimit + " :: " + root.data + " :: " + upperLimit);
		if (root.data > lowerLimit && root.data < upperLimit) {

		} else if (root.data < lowerLimit) {
			A = root;
		} else if (root.data > upperLimit) {
			B = root;
		}
		if (root.left != null) {
			recursive(root.left, lowerLimit, root.data);
		}
		if (root.right != null) {
			recursive(root.right, root.data, upperLimit);
		}

	}

}
