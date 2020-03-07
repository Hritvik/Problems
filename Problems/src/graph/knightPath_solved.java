package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class knightPath_solved {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		Scanner in = new Scanner(System.in);

		new HashMap<Float, Integer>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			a = Integer.parseInt(br.readLine());
			b = Integer.parseInt(br.readLine());
			c = Integer.parseInt(br.readLine());
			d = Integer.parseInt(br.readLine());
			e = Integer.parseInt(br.readLine());
			f = Integer.parseInt(br.readLine());
			System.out.println((new knightPath_solved()).knight(a, b, c, d, e, f));
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			in.close();
		}
	}

	public int knight(int a, int b, int c, int d, int e, int f) {
		try {
			boolean[][] visitedMatrix = new boolean[a + 1][b + 1];
			return findPath(a, b, c - 1, d - 1, e - 1, f - 1, visitedMatrix);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return -1;
	}

	private static int findPath(int x, int y, int c, int d, int e, int f, boolean[][] visitedMatrix) {
		int[][] distanceMatrix = new int[x][y];
		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix[i].length; j++) {
				distanceMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
		distanceMatrix[c][d] = 0;
		Queue<int[]> nodeQueue = new LinkedList<int[]>();
		nodeQueue.add(new int[] { c, d });
		while (!nodeQueue.isEmpty()) {
			int[] temp = nodeQueue.poll();
			int i = temp[0];
			int j = temp[1];
			if (i == e && j == f) {
				for (int k = 0; k < distanceMatrix.length; k++) {
					for (int k2 = 0; k2 < distanceMatrix[k].length; k2++) {
						if (distanceMatrix[k][k2] == Integer.MAX_VALUE) {
							System.out.print("- ");
						} else {
							System.out.print(distanceMatrix[k][k2] + " ");
						}
					}
					System.out.println();
				}
				System.out.println("----------");
				return distanceMatrix[e][f];
			} else {
				if (!visitedMatrix[i][j]) {
					visitedMatrix[i][j] = true;
					int a = i + 2;
					int b = j - 1;
					if (a > -1 && a < x && b > -1 && b < y && !visitedMatrix[a][b]) {
						nodeQueue.add(new int[] { a, b });
						if (distanceMatrix[a][b] > 1 + distanceMatrix[i][j]) {
							distanceMatrix[a][b] = 1 + distanceMatrix[i][j];
						}
					}
					a = i + 2;
					b = j + 1;
					if (a > -1 && a < x && b > -1 && b < y && !visitedMatrix[a][b]) {
						nodeQueue.add(new int[] { a, b });
						if (distanceMatrix[a][b] > 1 + distanceMatrix[i][j]) {
							distanceMatrix[a][b] = 1 + distanceMatrix[i][j];
						}
					}
					a = i - 2;
					b = j - 1;
					if (a > -1 && a < x && b > -1 && b < y && !visitedMatrix[a][b]) {
						nodeQueue.add(new int[] { a, b });
						if (distanceMatrix[a][b] > 1 + distanceMatrix[i][j]) {
							distanceMatrix[a][b] = 1 + distanceMatrix[i][j];
						}
					}
					a = i - 2;
					b = j + 1;
					if (a > -1 && a < x && b > -1 && b < y && !visitedMatrix[a][b]) {
						nodeQueue.add(new int[] { a, b });
						if (distanceMatrix[a][b] > 1 + distanceMatrix[i][j]) {
							distanceMatrix[a][b] = 1 + distanceMatrix[i][j];
						}
					}
					a = i + 1;
					b = j + 2;
					if (a > -1 && a < x && b > -1 && b < y && !visitedMatrix[a][b]) {
						nodeQueue.add(new int[] { a, b });
						if (distanceMatrix[a][b] > 1 + distanceMatrix[i][j]) {
							distanceMatrix[a][b] = 1 + distanceMatrix[i][j];
						}
					}
					a = i - 1;
					b = j + 2;
					if (a > -1 && a < x && b > -1 && b < y && !visitedMatrix[a][b]) {
						nodeQueue.add(new int[] { a, b });
						if (distanceMatrix[a][b] > 1 + distanceMatrix[i][j]) {
							distanceMatrix[a][b] = 1 + distanceMatrix[i][j];
						}
					}
					a = i + 1;
					b = j - 2;
					if (a > -1 && a < x && b > -1 && b < y && !visitedMatrix[a][b]) {
						nodeQueue.add(new int[] { a, b });
						if (distanceMatrix[a][b] > 1 + distanceMatrix[i][j]) {
							distanceMatrix[a][b] = 1 + distanceMatrix[i][j];
						}
					}
					a = i - 1;
					b = j - 2;
					if (a > -1 && a < x && b > -1 && b < y) {
						nodeQueue.add(new int[] { a, b });
						if (distanceMatrix[a][b] > 1 + distanceMatrix[i][j]) {
							distanceMatrix[a][b] = 1 + distanceMatrix[i][j];
						}
					}

				}

			}
		}
		return -1;
	}

}
