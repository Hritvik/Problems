package graph_BiDirectional_Cycle_Detector;

import java.util.LinkedList;
import java.util.Scanner;

class Graph {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int v = in.nextInt();
			int e = in.nextInt();
			LinkedList<Integer>[] alist = new LinkedList[v];
			for (int i = 0; i < v; i++)
				alist[i] = new LinkedList<Integer>();
			while (e-- > 0) {
				int n1 = in.nextInt();
				int n2 = in.nextInt();
				System.out.println("edge "+n1+" "+n2);
				alist[n1].add(n2);
			}
			boolean[] visited = new boolean[v];
			boolean[] explored = new boolean[v];
			GfG g = new GfG();
			if (g.hasCycle(v, alist, visited, explored)) {
				System.out.println(1);
			} else
				System.out.println(0);
		}
	}
}
