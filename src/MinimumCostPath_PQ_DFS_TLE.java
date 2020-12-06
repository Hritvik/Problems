import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumCostPath_PQ_DFS_TLE {
	static int minimumCost = Integer.MAX_VALUE;

	class Element {
		int value;
		int x;
		int y;

		Element(int value, int x, int y) {
			this.value = value;
			this.x = x;
			this.y = y;
		}
	}

	static Comparator<Element> c = new Comparator<MinimumCostPath_PQ_DFS_TLE.Element>() {

		@Override
		public int compare(Element o1, Element o2) {
			return o1.value - o2.value;
		}
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int T = Integer.parseInt(sc.nextLine());
			while (T-- > 0) {
				minimumCost = Integer.MAX_VALUE;
				int N = Integer.parseInt(sc.nextLine());
				String[] str = sc.nextLine().split(" ");
				int[][] matrix = new int[N][N];
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix.length; j++) {
						matrix[i][j] = Integer.parseInt(str[i * N + j]);
					}
				}
//				for (int i = 0; i < matrix.length; i++) {
//					for (int j = 0; j < matrix.length; j++) {
//						System.out.print(matrix[i][j] + " ");
//					}
//					System.out.println();
//				}
				boolean[][] visited = new boolean[N][N];
				(new MinimumCostPath_PQ_DFS_TLE()).solver(matrix, visited, 0, 0, 0);
				System.out.println(minimumCost);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

	private int solver(int[][] matrix, boolean[][] visited, int i, int j, int cost) {
		visited[i][j] = true;
		cost += matrix[i][j];

		if (cost > minimumCost) {
//			System.out.println("pruned");
		} else {
//			System.out.println(i + ", " + j);
			if (i == matrix.length - 1 && j == matrix.length - 1) {
//				for (int m = 0; m < matrix.length; m++) {
//					for (int n = 0; n < matrix.length; n++) {
//						if (visited[m][n]) {
//							System.out.print("T ");
//						} else {
//							System.out.print("F ");
//						}
//					}
//					System.out.println();
//				}
//				System.out.println("----------");
				if (cost < minimumCost) {
					minimumCost = cost;
				}
//				System.out.println("minimum = " + cost);
			} else {

				int x = -1;
				int y = -1;
				PriorityQueue<Element> q = new PriorityQueue<Element>(c);
				x = i + 1;
				y = j;
				if (x < matrix.length) {
					if (!visited[x][y]) {
						Element e = new Element(matrix[x][y], x, y);
						q.add(e);
					}
				}

				x = i;
				y = j + 1;
				if (y < matrix.length) {
					if (!visited[x][y]) {
						Element e = new Element(matrix[x][y], x, y);
						q.add(e);
					}
				}

				x = i - 1;
				y = j;
				if (x > -1) {
					if (!visited[x][y]) {
						Element e = new Element(matrix[x][y], x, y);
						q.add(e);
					}
				}

				x = i;
				y = j - 1;
				if (y > -1) {
					if (!visited[x][y]) {
						Element e = new Element(matrix[x][y], x, y);
						q.add(e);
					}
				}
//				Iterator<Element> itr = q.iterator();
//				while (itr.hasNext()) {
//					System.out.print(itr.next().value + " ");
//				}
//				System.out.println();
				int min = Integer.MAX_VALUE;
				while (!q.isEmpty()) {
					Element e = q.poll();
//					System.out.println(e.value + " ");
					int temp = solver(matrix, visited, e.x, e.y, cost);
					if (min > temp) {
						min = temp;
					}
				}
				cost = min;
			}

		}
		visited[i][j] = false;
		return cost;
	}

}
