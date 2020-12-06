import java.util.Scanner;

public class MinimumCostPath_DFS_TLE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int T = Integer.parseInt(sc.nextLine());
			while (T-- > 0) {
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
				int[][] min_cost_matrix = new int[N][N];
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix.length; j++) {
						min_cost_matrix[i][j] = Integer.MAX_VALUE;
					}
				}
				boolean[][] visited = new boolean[N][N];
				solver(matrix, min_cost_matrix, visited, 0, 0);
				for (int m = 0; m < matrix.length; m++) {
					for (int n = 0; n < matrix.length; n++) {
						if (min_cost_matrix[m][n] != Integer.MAX_VALUE) {
							System.out.print(min_cost_matrix[m][n] + " ");
						} else {
							System.out.print("-1 ");
						}
					}
					System.out.println();
				}
				for (int m = 0; m < matrix.length; m++) {
					for (int n = 0; n < matrix.length; n++) {
						if (visited[m][n]) {
							System.out.print("T ");
						} else {
							System.out.print("F ");
						}
					}
					System.out.println();
				}
				System.out.println(min_cost_matrix[0][0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

	private static void solver(int[][] matrix, int[][] min_cost_matrix, boolean[][] visited, int i, int j) {
		visited[i][j] = true;
//		System.out.println(i + ", " + j);

		if (i == matrix.length - 1 && j == matrix.length - 1) {
			for (int m = 0; m < matrix.length; m++) {
				for (int n = 0; n < matrix.length; n++) {
					if (min_cost_matrix[m][n] != Integer.MAX_VALUE) {
						System.out.print(min_cost_matrix[m][n] + " ");
					} else {
						System.out.print("-1 ");
					}
				}
				System.out.println();
			}
			for (int m = 0; m < matrix.length; m++) {
				for (int n = 0; n < matrix.length; n++) {
					if (visited[m][n]) {
						System.out.print("T ");
					} else {
						System.out.print("F ");
					}
				}
				System.out.println();
			}
			min_cost_matrix[i][j] = matrix[i][j];
		} else {
			int u = Integer.MAX_VALUE;
			int d = Integer.MAX_VALUE;
			int l = Integer.MAX_VALUE;
			int r = Integer.MAX_VALUE;
			int x = -1;
			int y = -1;
			x = i + 1;
			y = j;
			if (x < matrix.length) {
				if (visited[x][y] == false) {
					solver(matrix, min_cost_matrix, visited, x, y);
					d = min_cost_matrix[x][y];
				}
			}
			x = i;
			y = j + 1;
			if (y < matrix.length) {
				if (visited[x][y] == false) {
					solver(matrix, min_cost_matrix, visited, x, y);
					r = min_cost_matrix[x][y];
				}
			}
			x = i;
			y = j - 1;
			if (y > -1) {
				if (visited[x][y] == false) {
					solver(matrix, min_cost_matrix, visited, x, y);
					l = min_cost_matrix[x][y];
				}
			}
			x = i - 1;
			y = j;
			if (x > -1) {
				if (visited[x][y] == false) {
					solver(matrix, min_cost_matrix, visited, x, y);
					u = min_cost_matrix[x][y];
				}
			}

			int min = Math.min(Math.min(u, d), Math.min(l, r));

			if (min != Integer.MAX_VALUE) {
				if (min_cost_matrix[i][j] > matrix[i][j] + min) {
					min_cost_matrix[i][j] = matrix[i][j] + min;
				}
			} else {
//				System.out.println("min = " + min);
			}
		}
		visited[i][j] = false;
	}
}
