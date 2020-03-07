package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ValidPath_DFS_BFS {
//	55
//	34
//	5
//	1
//	12 7 18 55 1
//	30 0 33 2 28
//	yes

//	58
//	91
//	6
//	8
//	40 6 36 38 23 54
//	88 14 50 10 15 5
//	yes
	public static void main1(String[] args) {
		int x = 0;
		int y = 0;
		int N = 0;
		int R = 0;
		Scanner in = new Scanner(System.in);
		String stringArray[] = null;
		String temp_line = null;
		int[] xArray = null;
		int[] yArray = null;
		new HashMap<Float, Integer>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			x = Integer.parseInt(br.readLine());
			y = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			R = Integer.parseInt(br.readLine());
			xArray = new int[N];
			yArray = new int[N];
			temp_line = br.readLine();
			stringArray = temp_line.split(" ");

			for (int i = 0; i < stringArray.length; i++) {
				xArray[i] = Integer.parseInt(stringArray[i]);
			}
			temp_line = br.readLine();
			stringArray = temp_line.split(" ");
			for (int i = 0; i < stringArray.length; i++) {
				yArray[i] = Integer.parseInt(stringArray[i]);
			}
			boolean result = solver(x, y, N, R, xArray, yArray);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}

	public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
		int[] xArray = new int[E.size()];
		int[] yArray = new int[E.size()];
		for (int i = 0; i < E.size(); i++) {
			xArray[i] = E.get(i);
			yArray[i] = F.get(i);
		}

		if (solver(A, B, C, D, xArray, yArray)) {
			return "YES";
		}
		return "NO";
	}

	private static boolean solver(int x, int y, int n, int r, int[] xArray, int[] yArray) {
		try {
			boolean[][] circleMatrix = null;
			boolean[][] visitedMatrix = null;
			circleMatrix = new boolean[x + 1][y + 1];
			for (int i = 0; i <= x; i++) {
				for (int j = 0; j <= y; j++) {
					boolean flag = checkForCircle(i, j, xArray, yArray, r);
					circleMatrix[i][j] = flag;
				}
			}
			for (int i = 0; i <= x; i++) {
				for (int j = 0; j <= y; j++) {
					System.out.print(circleMatrix[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("-------------");
			visitedMatrix = new boolean[x + 1][y + 1];
			return findPathDFS_recursive_not_working(0, 0, visitedMatrix, circleMatrix);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean findPathDFS(int i, int j, boolean[][] visitedMatrix, boolean[][] circleMatrix) {
		int x = circleMatrix.length;
		int y = circleMatrix[0].length;
		Stack<int[]> nodeStack = new Stack<int[]>();
		nodeStack.add(new int[] { i, j });
		while (!nodeStack.empty()) {
			int[] temp = nodeStack.pop();
			int i_itr = temp[0];
			int j_itr = temp[1];
			System.out.println(i_itr + " :: " + j_itr);
			if (i_itr == x && j_itr == y) {
				return true;
			} else {
				if (i_itr > -1 && i_itr < x && j_itr > -1 && j_itr < y && !visitedMatrix[i_itr][j_itr]
						&& !circleMatrix[i_itr][j_itr]) {
					visitedMatrix[i_itr][j_itr] = true;
					nodeStack.add(new int[] { i_itr + 1, j_itr });
					nodeStack.add(new int[] { i_itr - 1, j_itr });
					nodeStack.add(new int[] { i_itr, j_itr + 1 });
					nodeStack.add(new int[] { i_itr, j_itr - 1 });
					nodeStack.add(new int[] { i_itr + 1, j_itr + 1 });
					nodeStack.add(new int[] { i_itr + 1, j_itr - 1 });
					nodeStack.add(new int[] { i_itr - 1, j_itr + 1 });
					nodeStack.add(new int[] { i_itr - 1, j_itr - 1 });
				}
			}
		}
		return false;
	}

	private static boolean findPathBFS_working(int i, int j, boolean[][] visitedMatrix, boolean[][] circleMatrix) {
		int x = circleMatrix.length;
		int y = circleMatrix[0].length;
		Queue<int[]> nodeQueue = new LinkedList<int[]>();
		nodeQueue.add(new int[] { i, j });
		while (!nodeQueue.isEmpty()) {
			int[] temp = nodeQueue.poll();
			int i_itr = temp[0];
			int j_itr = temp[1];
			System.out.println(i_itr + " :: " + j_itr);
			if (i_itr == x && j_itr == y) {
				return true;
			} else {
				if (i_itr > -1 && i_itr < x && j_itr > -1 && j_itr < y && !visitedMatrix[i_itr][j_itr]
						&& !circleMatrix[i_itr][j_itr]) {
					visitedMatrix[i_itr][j_itr] = true;
					nodeQueue.add(new int[] { i_itr + 1, j_itr });
					nodeQueue.add(new int[] { i_itr - 1, j_itr });
					nodeQueue.add(new int[] { i_itr, j_itr + 1 });
					nodeQueue.add(new int[] { i_itr, j_itr - 1 });
					nodeQueue.add(new int[] { i_itr + 1, j_itr + 1 });
					nodeQueue.add(new int[] { i_itr + 1, j_itr - 1 });
					nodeQueue.add(new int[] { i_itr - 1, j_itr + 1 });
					nodeQueue.add(new int[] { i_itr - 1, j_itr - 1 });
				}
			}
		}
		return false;
	}


	private static boolean findPathDFS_recursive_not_working(int i, int j, boolean[][] visitedMatrix, boolean[][] circleMatrix) {
		int x = circleMatrix.length;
		int y = circleMatrix[0].length;
		System.out.println(i + " :: " + j);
		visitedMatrix[i][j] = true;
		if (i == x && j == y) {
			return true;
		} else {
			boolean a = false;
			boolean b = false;
			boolean c = false;
			boolean d = false;
			boolean e = false;
			boolean f = false;
			boolean g = false;
			boolean h = false;
			if (i + 1 < x && !visitedMatrix[i + 1][j] && !circleMatrix[i + 1][j]) {// down
				a = findPathDFS_recursive_not_working(i + 1, j, visitedMatrix, circleMatrix);
			}
			if (i - 1 > -1 && !visitedMatrix[i - 1][j] && !circleMatrix[i - 1][j]) {// up
				b = findPathDFS_recursive_not_working(i - 1, j, visitedMatrix, circleMatrix);
			}
			if (j + 1 < y && !visitedMatrix[i][j + 1] && !circleMatrix[i][j + 1]) {// right
				c = findPathDFS_recursive_not_working(i, j + 1, visitedMatrix, circleMatrix);
			}
			if (j - 1 > -1 && !visitedMatrix[i][j - 1] && !circleMatrix[i][j - 1]) {// left
				d = findPathDFS_recursive_not_working(i, j - 1, visitedMatrix, circleMatrix);
			}
			if (i + 1 < x && j + 1 < y && !visitedMatrix[i + 1][j + 1] && !circleMatrix[i + 1][j + 1]) {// down right
				e = findPathDFS_recursive_not_working(i + 1, j + 1, visitedMatrix, circleMatrix);
			}
			if (i + 1 < x && j - 1 > -1 && !visitedMatrix[i + 1][j - 1] && !circleMatrix[i + 1][j - 1]) {// down left
				f = findPathDFS_recursive_not_working(i + 1, j - 1, visitedMatrix, circleMatrix);
			}
			if (i - 1 > -1 && j + 1 < y && !visitedMatrix[i - 1][j + 1] && !circleMatrix[i - 1][j + 1]) {// up right
				g = findPathDFS_recursive_not_working(i - 1, j + 1, visitedMatrix, circleMatrix);
			}
			if (i - 1 > -1 && j - 1 > -1 && !visitedMatrix[i - 1][j - 1] && !circleMatrix[i - 1][j - 1]) {// up left
				h = findPathDFS_recursive_not_working(i - 1, j - 1, visitedMatrix, circleMatrix);
			}
			return (a || b || c || d || e || f || g || h);
		}
	}

	private static boolean checkForCircle(int i, int j, int[] xArray, int[] yArray, int r) {
		for (int k = 0; k < xArray.length; k++) {
			if (distance(i, j, xArray[k], yArray[k]) - Math.pow(2, -.5) < r) {
				return true;
			}
		}
		return false;
	}

	private static double distance(int i, int j, int x, int y) {
		double result = Math.pow(Math.pow((i - x), 2) + Math.pow((j - y), 2), .5);
//		System.out.println("[" + i + "," + j + "]" + " - " + "[" + x + "," + y + "]" + " = " + result);
		return Math.ceil(result);
	}

}
