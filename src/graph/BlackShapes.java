package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BlackShapes {

	public static void main(String[] args) {
		int a = 0;
		Scanner in = new Scanner(System.in);
		new HashMap<Float, Integer>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			a = Integer.parseInt(br.readLine());
			ArrayList<String> list = new ArrayList<String>();
			while (a-- > 0) {
				list.add(br.readLine());
			}
			System.out.println((new BlackShapes()).black(list));
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			in.close();
		}
	}

	public int black(ArrayList<String> A) {
		char[][] matrix = new char[A.size()][A.get(0).length()];
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).length(); j++) {
				matrix[i][j] = A.get(i).charAt(j);
			}
		}
		boolean[][] visited = new boolean[A.size()][A.get(0).length()];
		int counter = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 'X' && !visited[i][j]) {
					findShape(matrix, visited, i, j);
					counter++;
				}
			}
		}
		for (int k = 0; k < visited.length; k++) {
			for (int k2 = 0; k2 < visited[k].length; k2++) {
				if (visited[k][k2] == true) {
					System.out.print("t ");
				} else {
					System.out.print("f ");
				}
			}
			System.out.println();
		}
		System.out.println("----------");
		return counter;
	}

	private void findShape(char[][] matrix, boolean[][] visited, int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			if (!visited[x][y]) {
				visited[x][y] = true;
				int a = x + 1;
				int b = y;
				if (a > -1 && a < matrix.length && b > -1 && b < matrix[0].length && !visited[a][b]
						&& matrix[a][b] == 'X') {
					q.add(new int[] { a, b });
				}
				a = x - 1;
				b = y;
				if (a > -1 && a < matrix.length && b > -1 && b < matrix[0].length && !visited[a][b]
						&& matrix[a][b] == 'X') {
					q.add(new int[] { a, b });
				}
				a = x;
				b = y + 1;
				if (a > -1 && a < matrix.length && b > -1 && b < matrix[0].length && !visited[a][b]
						&& matrix[a][b] == 'X') {
					q.add(new int[] { a, b });
				}
				a = x;
				b = y - 1;
				if (a > -1 && a < matrix.length && b > -1 && b < matrix[0].length && !visited[a][b]
						&& matrix[a][b] == 'X') {
					q.add(new int[] { a, b });
				}
			}
		}
	}
}
