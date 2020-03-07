package largestRectangle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class attempt1 {
	static int[][] matrix;
//	static HashMap<String, Long> memoryT = new HashMap<String, Long>();
	static long[][][][] memory = null;
	static int R = 0;
	static int C = 0;

	// 0 :: 4 2
	public static void main(String[] args) {
		InputStream is = null;

		int T = 0;
		try {
//			is = System.in;
			is = new FileInputStream("Largest_Rectangle/0.txt");
			InputStreamReader in = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(in);
			StringBuffer sb = new StringBuffer();
			String[] strArray = null;
			T = Integer.parseInt(bf.readLine());
			while (T != 0) {
				String temp[] = bf.readLine().split(" ");
				R = Integer.parseInt(temp[0]);
				C = Integer.parseInt(temp[1]);
				memory = new long[R][R][C][C];
				matrix = new int[R][C];
				strArray = bf.readLine().split(" ");
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						matrix[i][j] = Integer.parseInt(strArray[i * C + j]);
						System.out.print(matrix[i][j] + " ");
					}
					System.out.println();
				}
				long result = solverStart();
				sb.append(result);
				if (T != 1) {
					sb.append("\n");
				}
				T--;
			}
			System.out.println(sb);
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static long solverStart() {
		for (int startX = 0; startX < R; startX++) {
			for (int startY = 0; startY < C; startY++) {
				solverEnd(startX, startX, startY, startY);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					for (int l = 0; l < C; l++) {
						System.out.println(i + " " + j + " " + k + " " + l + " :: " + memory[i][j][k][l]);
					}
				}
			}
		}
		return 0;
	}

	private static long solverEnd(int x, int x2, int y, int y2) {
		if (matrix[x2][y2] == 0) {
			System.out.println(x + " " + x2 + " " + y + " " + y2 + " :: " + 0);
			return 0;
		} else {
			for (int i = x; i < R; i++) {
				for (int j = y; j < C; j++) {
					if (x == x2) {
						long v = solverEnd(x + 1, x + i, y, y);
						memory[x][x + i][y][y] = 1 + v;
						System.out.println(x + " " + x2 + " " + y + " " + y2 + " :: " + (1 + v));
						return 1 + v;
					} else {
						if (y == y2) {
							long h = solverEnd(x, x, y + 1, y + j);
							memory[x][x][y][y + j] = 1 + h;
							System.out.println(x + " " + x2 + " " + y + " " + y2 + " :: " + (1 + h));
							return 1 + h;
						} else {
							long v = solverEnd(x + 1, x + i, y, y);
							memory[x][x + i][y][y] = 1 + v;
							long h = solverEnd(x, x, y + 1, y + j);
							memory[x][x][y][y + j] = 1 + h;
							long result = 1 + solverEnd(x + 1, x + i, y + 1, y + j) + h + v;
							memory[x][x + i][y][y + j] = result;
							System.out.println(x + " " + x2 + " " + y + " " + y2 + " :: " + result);
							return result;
						}
					}

				}
			}
			System.out.println("unknown case");
			return 0;
		}
	}
}
