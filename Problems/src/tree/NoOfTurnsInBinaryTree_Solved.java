package tree;

import java.util.Scanner;
//1
//6
//0 1 L 0 2 R  1 3 L 1 4 R  2 5 L 2 6 R
//4 4
//
//Its Correct output is:
//-1
//
//And Your Code's output is:
//1
//
///////////////////////////////////////////////////////////////////////
//2
//2
//1 2 L 1 3 R
//2 3
//9
//1 2 L 1 3 R 2 4 L 2 5 R  3 6 L 3 7 R 4 8 L 6 9 L 6 10 R
//5 10
//Output:
//1
//4
/////////////////////////////////////////////////////////////////////////////
//2
//14 
//0 1 L 0 2 R  1 3 L 1 4 R  2 5 L 2 6 R  3 7 L 3 8 R  4 9 L 4 10 R  5 11 L 5 12 R  6 13 L 6 14 R  
//4 6
//6 
//0 1 L 0 2 R  1 3 L 1 4 R  2 5 L 2 6 R  
//1 5
//Output is:
//2
//2
/////////////////////////////////////////////////////////////////////////////
//1
//62
//0 1 L 0 2 R  1 3 L 1 4 R  2 5 L 2 6 R  3 7 L 3 8 R  4 9 L 4 10 R  5 11 L 5 12 R  6 13 L 6 14 R  7 15 L 7 16 R  8 17 L 8 18 R  9 19 L 9 20 R  10 21 L 10 22 R  11 23 L 11 24 R  12 25 L 12 26 R  13 27 L 13 28 R  14 29 L 14 30 R  15 31 L 15 32 R  16 33 L 16 34 R  17 35 L 17 36 R  18 37 L 18 38 R  19 39 L 19 40 R  20 41 L 20 42 R  21 43 L 21 44 R  22 45 L 22 46 R  23 47 L 23 48 R  24 49 L 24 50 R  25 51 L 25 52 R  26 53 L 26 54 R  27 55 L 27 56 R  28 57 L 28 58 R  29 59 L 29 60 R  30 61 L 30 62 R
//0 46
//Its Correct output is:
//1

class Nodey {
	int data;
	Nodey left, right;

	Nodey(int item) {
		data = item;
		left = right = null;
	}
}

class NoOfTurnsInBinaryTree_Solved {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Nodey root = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int a1 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (i == 0) {
					root = new Nodey(a);
					switch (lr) {
					case 'L':
						root.left = new Nodey(a1);
						break;
					case 'R':
						root.right = new Nodey(a1);
						break;
					}
				} else {
					insert(root, a, a1, lr);
				}
			}
			int nd1 = sc.nextInt();
			int nd2 = sc.nextInt();
			int turn;
			GFG2 g = new GFG2();
			if ((turn = g.NumberOfTurn(root, nd1, nd2)) != 0)
				System.out.println(turn);
			else
				System.out.println("-1");

		}
	}

	public static void insert(Nodey root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Nodey(a1);
				break;
			case 'R':
				root.right = new Nodey(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */
//User function Template for Java
/*
 * Nodey defined as class Nodey{ int data; Nodey left,right; Nodey(int d){
 * data=d; left=right=null; } }
 */
class GFG2 {
	String firstPath = "";
	String secondPath = "";

	int NumberOfTurn(Nodey root, int first, int second) {
		firstPath = "";
		secondPath = "";

		recursive(root, first, second, "");
		System.out.println(firstPath);
		System.out.println(secondPath);
		if ((secondPath != "" && firstPath.startsWith(secondPath))
				|| (firstPath != "" && secondPath.startsWith(firstPath))) {
			return -1;
		} else {

			int i = 0;
			int counter = 0;
			int minSize = Math.min(firstPath.length(), secondPath.length());
			while (i < minSize) {
				if (firstPath.charAt(i) == secondPath.charAt(i)) {
					counter++;
				} else {
					break;
				}
				i++;
			}
			int f = counterTurns(firstPath, counter);
			int s = counterTurns(secondPath, counter);
			System.out.println("c = " + counter + " f = " + f + " s = " + s);
			if (secondPath == "" || firstPath == "") {
				return f + s;
			} else {
				return 1 + f + s;
			}

		}
	}

	private int counterTurns(String path, int start) {
		int counter = 0;
		for (int i = start + 1; i < path.length(); i++) {
			if (path.charAt(i - 1) != path.charAt(i)) {
				counter++;
			}
		}
		return counter;
	}

	void recursive(Nodey root, int first, int second, String path) {
		if (root.data == first) {
			firstPath = path;
		}
		if (root.data == second) {
			secondPath = path;
		}
		if (firstPath == "" || secondPath == "") {
			if (root.right != null) {
				recursive(root.right, first, second, path + "R");
			}
			if (root.left != null) {
				recursive(root.left, first, second, path + "L");
			}
		}
	}
}