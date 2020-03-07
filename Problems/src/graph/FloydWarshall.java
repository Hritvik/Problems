package graph;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class FloydWarshall {

	public static void main(String[] args) {
		InputStream is = null;
		Scanner scanner = null;
		try {
//			is = System.in;
			is = new FileInputStream("FloydWarshall/0.txt");
			scanner = new Scanner(is);
			int T = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			while (T-- > 0) {
				int V = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				int[][] matrix = new int[V][V];
				for (int j = 0; j < V; j++) {
					String temp = scanner.nextLine();
					scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
					String[] arr = temp.split(" ");
					for (int k = 0; k < arr.length; k++) {
						if (arr[k].startsWith("I")) {
							matrix[j][k] = -1;
						} else {
							matrix[j][k] = Integer.parseInt(arr[k]);
						}
					}
				}
				solver(matrix);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void solver(int[][] matrix) {
		

	}

}

class Graph {
	Graph up = null;
	Graph down = null;
	Graph left = null;
	Graph right = null;
	int x = 0;
	int y = 0;
	
}
