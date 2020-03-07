package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class colorMatrix {
	public static void main(String[] args) {
		int T = 0;
		int rowSize = 0;
		int colSize = 0;
		int x = 0;
		int y = 0;
		int K = 0;
		Scanner in = new Scanner(System.in);
		String stringArray[] = null;
		String temp_line = null;
		// ArrayList<Long> intArray = new ArrayList<Long>();
		int intMatrix[][] = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb = new StringBuffer();
			T = Integer.parseInt(br.readLine());
			while (T != 0) {
				temp_line = br.readLine();
				rowSize = Integer.parseInt(temp_line.split(" ")[0]);
				colSize = Integer.parseInt(temp_line.split(" ")[1]);
//				System.out.println("N = " + N + " M = " + M);
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
//				System.out.print("stringArray :: ");
//				for (int i = 0; i < stringArray.length; i++) {
//					System.out.print(stringArray[i] + " ");
//				}
//				System.out.println();

				intMatrix = new int[rowSize][colSize];

				for (int i = 0; i < rowSize; i++) {
					for (int j = 0; j < colSize; j++) {
//						System.out.println("i = " + i + " j = " + j + " :: i * colSize + j = " + (i * colSize + j));
						intMatrix[i][j] = Integer.parseInt(stringArray[((i * colSize) + j)]);
					}
				}
				
				/*
				 * System.out.println(); for (int i = 0; i < rowSize; i++) { for (int j = 0; j <
				 * colSize; j++) { System.out.print(intMatrix[i][j] + " "); }
				 * System.out.println(); }
				 */
				 
				temp_line = br.readLine();
				x = Integer.parseInt(temp_line.split(" ")[0]);
				y = Integer.parseInt(temp_line.split(" ")[1]);
				K = Integer.parseInt(temp_line.split(" ")[2]);
				color(intMatrix, x, y, intMatrix[x][y], K, rowSize, colSize);
				for (int i = 0; i < rowSize; i++) {
					for (int j = 0; j < colSize; j++) {
						sb.append(intMatrix[i][j] + " ");
					}
				}
				if (T!=1) {
					sb.append("\n");
				}
				T--;
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}

	private static void color(int[][] intMatrix, int x, int y, int prevColor, int newColor, int rowSize, int colSize) {
		intMatrix[x][y] = newColor;
		int i = 0;
		int j = 0;
		i = x - 1;
		j = y;
		if (i >= 0 && i < rowSize && j >= 0 && j < colSize && intMatrix[i][j] == prevColor) {
			color(intMatrix, i, j, prevColor, newColor, rowSize, colSize);
		}
		i = x + 1;
		j = y;
		if (i >= 0 && i < rowSize && j >= 0 && j < colSize && intMatrix[i][j] == prevColor) {
			color(intMatrix, i, j, prevColor, newColor, rowSize, colSize);
		}
		j = y - 1;
		i = x;
		if (i >= 0 && i < rowSize && j >= 0 && j < colSize && intMatrix[i][j] == prevColor) {
			color(intMatrix, i, j, prevColor, newColor, rowSize, colSize);
		}
		j = y + 1;
		i = x;
		if (i >= 0 && i < rowSize && j >= 0 && j < colSize && intMatrix[i][j] == prevColor) {
			color(intMatrix, i, j, prevColor, newColor, rowSize, colSize);
		}
	}

}
