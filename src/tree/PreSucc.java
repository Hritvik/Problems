package tree;

import java.util.Scanner;

class Res {
	Nodeq pre = null;
	Nodeq succ = null;
}

class Nodeq {
	int data;
	Nodeq left, right;

	Nodeq(int item) {
		data = item;
		left = right = null;
	}
}
class GFG4 {

	public void findPreSuc(Nodeq root, Res p, Res s, int key) {
		inorderTraversal(root);
	}

	private void inorderTraversal(Nodeq currNodeq) {
		if (currNodeq != null) {
			inorderTraversal(currNodeq.left);
			System.out.println(currNodeq.data);
			inorderTraversal(currNodeq.right);
		}
	}
}

class PreSucc {

	public void insert(Nodeq root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Nodeq(a1);
				break;
			case 'R':
				root.right = new Nodeq(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Nodeq root = null;
			Res p = new Res();
			Res s = new Res();
			for (int i = 0; i < n; i++) {

				int a = sc.nextInt();
				int a1 = sc.nextInt();

				char lr = sc.next().charAt(0);

				if (i == 0) {

					root = new Nodeq(a);

					switch (lr) {

					case 'L':
						root.left = new Nodeq(a1);
						break;
					case 'R':
						root.right = new Nodeq(a1);
						break;
					}
				} else {
					(new PreSucc()).insert(root, a, a1, lr);
				}
			}

			int key = sc.nextInt();
			GFG4 g = new GFG4();
			g.findPreSuc(root, p, s, key);

			if (p.pre != null)
				System.out.print(p.pre.data + " ");
			else
				System.out.print("-1" + " ");

			if (s.succ != null)
				System.out.println(s.succ.data);
			else
				System.out.println("-1");

		}
	}

}