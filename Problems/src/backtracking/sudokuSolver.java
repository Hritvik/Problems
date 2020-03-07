package backtracking;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class sudokuSolver {
	public static int[][] matrix = new int[9][9];
	public static StringBuffer sbx = new StringBuffer();
	public static boolean debug = false;

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		int T = 0;
		String tempLine = null;
		String[] tempStrArray = null;
		try {
			T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				tempLine = br.readLine();
				tempStrArray = tempLine.split("\\s+");
				for (int j = 0; j < tempStrArray.length; j++) {
					matrix[j / 9][j % 9] = Integer.parseInt(tempStrArray[j]);
				}

				if (debug) {
					System.out.println("Input");
					for (int i = 0; i < 9; i++) {
						for (int j = 0; j < 9; j++) {
							System.out.print(matrix[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
				}

				int[] tempArray = matrixNext(0, 0);
				if (sudokuSolver(tempArray[0], tempArray[1])) {
					for (int i = 0; i < 9; i++) {
						for (int j = 0; j < 9; j++) {
							sb.append(matrix[i][j] + " ");
						}
						if (debug) {
							sb.append("\n");
						}
					}
				} else {
					if (debug) {
						for (int i = 0; i < 9; i++) {
							for (int j = 0; j < 9; j++) {
								sb.append(matrix[i][j] + " ");
							}
							sb.append("\n");
						}
					}
					System.out.println("-1");
				}

				if (debug) {
					FileWriter fw = new FileWriter("src/abc.txt");
					fw.write(sbx.toString());
					fw.flush();
					fw.close();
				}
				if (T >= 1)
					sb.append("\n");
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean sudokuSolver(int x, int y) {
		if (debug) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sbx.append(matrix[i][j] + " ");
				}
				sbx.append("\n");
			}
			sbx.append("sudokuSolver :: x = " + x + ", y = " + y);
			sbx.append("\n");
		}

		for (int i = 1; i < 10; i++) {
			matrix[x][y] = i;
			if (debug) {
				sbx.append("x = " + x + ", y = " + y + " i = " + i + " " + constraintChecker(x, y) + "\n");
			}
			if (constraintChecker(x, y)) {
				int[] temp = matrixNext(x, y);
				if (temp[0] != -1) {
					if (sudokuSolver(temp[0], temp[1])) {
						return true;
					}
				} else {
					break;
				}
			}

		}
		int[] temp = matrixNext(x, y);
		if (temp[0] != -1 || !constraintChecker(x, y)) {
			matrix[x][y] = 0;
			return false;
		} else {
			return true;
		}
	}

	private static int[] matrixNext(int x, int y) {
		int[] result = new int[2];
		int i = x;
		int j = y;
		while (i < 9 && j < 9 && matrix[i][j] != 0) {
			if ((i + 1) < 9) {
				i = i + 1;
			} else {
				if ((y + 1) < 9) {
					i = 0;
					j = j + 1;
				} else {
					i = -1;
					break;
				}
			}
		}
		if (!(i < 9 && j < 9)) {
			i = -1;
		} else {
//			System.out.println("matrixNext = " + i + ", " + j);
		}
		result[0] = i;
		result[1] = j;
		return result;
	}

	private static boolean constraintChecker(int x, int y) {
		int value = matrix[x][y];
//		System.out.println("constraintChecker :: x " + x + " y " + y + " value " + value);
		for (int i = 0; i < 9; i++) {
			if ((i != x && matrix[i][y] == value) || (i != y && matrix[x][i] == value)) {
//				System.out.println("constraint failed :: matrix[" + i + "][y] " + matrix[i][y] + " matrix[x][" + i
//						+ "] " + matrix[x][i]);
				return false;
			}
		}
		int keyX = (x) / 3;
		int keyY = (y) / 3;
		int xm = keyX * 3;
		int xM = keyX * 3 + 2;
		int ym = keyY * 3;
		int yM = keyY * 3 + 2;
//		System.out.println("xm = " + xm + ", xM = " + xM + ", ym = " + ym + ", yM = " + yM + ", keyX = " + keyX
//				+ ", keyY = " + keyY);
		for (int i = xm; i <= xM; i++) {
			for (int j = ym; j <= yM; j++) {
				if (matrix[i][j] == value && i != x && j != y) {
//					System.out.println("constraintChecker failed :: box " + matrix[i][j] + " " + value);
					return false;
				}
			}
		}
//		System.out.println("constraint passed with value " + value);
		return true;
	}
}
