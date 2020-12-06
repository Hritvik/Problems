package recursion;
public class Josephus_Solved {
	class Element {
		int value;
		Element next;
		Element prev;

		public Element(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
//		int N = 5;
//		int K = 3;
		int N = 17;
		int K = 16;
//		int N = 3;
//		int K = 2;
		(new Josephus_Solved()).solve(N, K);
	}

	private void solve(int n, int k) {
		Element p = null;
		Element first = null;
		for (int i = 1; i <= n; i++) {
			Element e = new Element(i);
			if (i == 1) {
				first = e;
			}
			if (i == n) {
				e.next = first;
				first.prev = e;
			}
			if (p != null) {
				p.next = e;
				e.prev = p;
			}
			p = e;
		}

		recursive(first, k);
	}

	private static void recursive(Element curr, int k) {
		int i = 0;
		while (i < k - 1 || curr.next == null) {
			curr = curr.next;
			i++;
		}
		if (curr.next != curr) {
//			System.out.print("deleting :: [" + curr.prev.value + "," + curr.value + "," + curr.next.value + "], ");
			curr.next.prev = curr.prev;
			curr.prev.next = curr.next;
			recursive(curr.next, k);
		} else {
			System.out.println(curr.value);
		}
	}

}
