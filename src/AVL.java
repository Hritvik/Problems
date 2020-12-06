import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

class Nodez {
	int data;
	int height;
	Nodez left, right;

	Nodez(int d) {
		data = d;
		height = 0;
		left = null;
		right = null;
	}
}

class AVL {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("AVL/0.txt");
//			is = System.in;
			Scanner sc = new Scanner(is);
			int t = sc.nextInt();
			while (t-- > 0) {
				int n = sc.nextInt();
				boolean f = true;
				if (n == 0) {
					System.out.println("1");
					continue;
				}
				if (n == 1) {
					int a = sc.nextInt();
					System.out.println("1");
					continue;
				}
				if (n == 2) {
					int a = sc.nextInt();
					a = sc.nextInt();
					System.out.println("1");
					continue;
				} else {
					GfG g = new GfG();
					Nodez root = null;
					Nodez proot = null;
					f = true;
					while (n-- > 0) {
						int a = sc.nextInt();
						proot = g.insertToAVL(root, a);
						if (isBalanced(proot) == 0) {
							f = false;
							break;
						}
						if (!_B(root)) {
							if (I_(root)) {
								f = false;
								break;
							}
						}
					}
				}
				if (f == true)
					System.out.println("1");
				else
					System.out.println("0");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int _B_(Nodez root) {
		if (root == null)
			return 0;
		int lH = _B_(root.left);
		if (lH == -1)
			return -1;
		int rH = _B_(root.right);
		if (rH == -1)
			return -1;
		if (Math.abs(lH - rH) > 1)
			return -1;
		return Math.max(lH, rH) + 1;
	}

	public static boolean _B(Nodez root) {
		if (_B_(root) == -1)
			return false;
		else
			return true;
	}

	public static int isBalanced(Nodez root) {
		int lh;
		int rh;
		if (root == null)
			return 1;
		lh = heigh(root.left);
		rh = heigh(root.right);

		if (Math.abs(lh - rh) <= 1)
			if (isBalanced(root.left) == 1)
				if (isBalanced(root.right) == 1)
					return 1;
		return 0;
	}

	public static int heigh(Nodez node) {
		if (node == null)
			return 0;
		return 1 + Math.max(heigh(node.left), heigh(node.right));
	}

	public static boolean I_(Nodez root) {
		Nodez prev = null;
		if (root != null) {
			if (!I_(root.left))
				return false;
			if (prev != null && root.data <= prev.data)
				return false;
			prev = root;
			return I_(root.right);
		}
		return true;
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * The Nodez class is as follows class Nodez{
 * 
 * int height; int data; Nodez left,right; Nodez(int data) { this.data = data;
 * this.height = 0; this.left = null; this.right = null; } }
 */
class GfG {
	public Nodez insertToAVL(Nodez node, int data) {
		if (node == null) {
			System.out.println("root inserted with data :: "+data);
			return (new Nodez(data));
		}
		return recursive(node, data, true)[0];

	}

	public Nodez[] recursive(Nodez node, int data, boolean root) {
		System.out.println("nodeData = " + node.data);

		if (data > node.data) {
			if (node.right != null) {
				int temp = recursive(node.right, data, false)[1].data;
				if (temp == 2 || temp == -2) {
					rotate(node, temp);
					Nodez[] arr = { node, new Nodez(0) };
					return arr;
				} else {
					if (temp == 1) {
						Nodez[] arr = { node, new Nodez(2) };
						return arr;
					} else {
						if (temp == -1) {
							Nodez[] arr = { node, new Nodez(-2) };
							return arr;
						} else {
							Nodez[] arr = { node, new Nodez(0) };
							return arr;
						}
					}
				}
			} else {
				Nodez temp = new Nodez(data);
				node.right = temp;
				Nodez[] arr = { node, new Nodez(1) };
				return arr;
			}
		} else {
			if (node.left != null) {
				int temp = recursive(node.left, data, false)[1].data;
				if (temp == 2 || temp == -2) {
					rotate(node, temp);
					Nodez[] arr = { node, new Nodez(0) };
					return arr;
				} else {
					if (temp == 1) {
						Nodez[] arr = { node, new Nodez(2) };
						return arr;
					} else {
						if (temp == -1) {
							Nodez[] arr = { node, new Nodez(-2) };
							return arr;
						} else {
							Nodez[] arr = { node, new Nodez(0) };
							return arr;
						}
					}
				}
			} else {
				Nodez temp = new Nodez(data);
				node.left = temp;
				Nodez[] arr = { node, new Nodez(-1) };
				return arr;
			}

		}
	}

	public static void rotate(Nodez parent, int direction) {
		System.out.println("rotate");
		Nodez node = null;
		Nodez temp2 = null;
		if (direction == 2) {
			node = parent.right;
		} else {
			node = parent.left;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		if (lh > rh) {
			Nodez temp = node;
			temp2 = node.left.right;
			node = node.left;
			node.right = temp;
			node.left.right = temp2;
		} else {
			if (lh < rh) {
				Nodez temp = node;
				temp2 = node.right.left;
				node = node.right;
				node.left = temp;
				node.right.left = temp2;
			}
		}
		if (direction == 2) {
			parent.right = node;
		} else {
			parent.left = node;
		}
	}

	public static int height(Nodez node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
}