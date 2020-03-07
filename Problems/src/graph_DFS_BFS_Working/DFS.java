package graph_DFS_BFS_Working;

import java.util.LinkedList;
import java.util.Scanner;

class DFS {
	private static int V;
	private static LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	DFS(int v) {
		V = v;
		adj = new LinkedList[10001];
		for (int i = 0; i < 10001; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			boolean[] vis = new boolean[10001];
			for (int i = 0; i < 10001; i++)
				vis[i] = false;
			int n = sc.nextInt();
			DFS d = new DFS(n);
			for (int i = 0; i < n; i++)
				addEdge(sc.nextInt(), sc.nextInt());
			GfG g = new GfG();
			for (int i = 0; i < adj.length; i++) {
				if (adj[i].size()!=0) {
					System.out.println(i +" "+adj[i]);
				}
			}
			g.DFS(1, adj, vis);
		}
	}

	public static void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
}