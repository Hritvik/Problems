package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class travellingSalesman_Solved {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int T = Integer.parseInt(sc.nextLine());
			while (T-- > 0) {
				int N = Integer.parseInt(sc.nextLine());
				int[][] matrix = new int[N][N];
				String[] temp = sc.nextLine().split("\\s+");
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						matrix[i][j] = Integer.parseInt(temp[i * N + j]);
					}
				}
				System.out.println();
				solve(matrix);
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void solve(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		ArrayList<Integer> vertices = new ArrayList<Integer>();
		for (int i = 1; i < matrix.length; i++) {
			vertices.add(i);
		}
		int cost = recursive("0->", matrix, 0, vertices);
		System.out.println(cost);
	}

	private static int recursive(String path, int[][] matrix, int prev_vertex, ArrayList<Integer> vertices) {
//		System.out.println("////////////////*************************************[" + path + "]");
		int result = 0;
		int min = 999999;
		int chosenVertex = 0;
		if (vertices.size() > 1) {
			for (int i = 0; i < vertices.size(); i++) {
				int currVertex = vertices.get(i);
				ArrayList<Integer> tempVertices = new ArrayList<Integer>();
				tempVertices.addAll(vertices);
				tempVertices.remove(i);
//				System.out.print("path = " + path + " :: currentVertex = " + currVertex + " :: remaining vertices :: ");
				for (int j = 0; j < tempVertices.size(); j++) {
					System.out.print(tempVertices.get(j) + " ");
				}
				System.out.println();
				int cost = recursive(path + currVertex + "->", matrix, currVertex, tempVertices);
				int finalCost = cost + matrix[prev_vertex][currVertex];
				if (finalCost < min) {
					min = finalCost;
					chosenVertex = currVertex;
				}
			}
//			System.out.println("path = " + path + " :: chose :: " + chosenVertex + " at cost " + min);
			result = min;
		} else {
			chosenVertex = vertices.get(0);
			int cost = matrix[chosenVertex][0];
			int finalCost = matrix[prev_vertex][chosenVertex] + cost;
			System.out.println("path = " + path + " :: only choice :: " + chosenVertex + " at cost " + finalCost);
			result = finalCost;
		}
//		System.out.println("*************************************////////////////[" + path + "]");
		return result;
	}
}
