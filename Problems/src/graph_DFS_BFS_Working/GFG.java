package graph_DFS_BFS_Working;

import java.util.ArrayList;
import java.util.LinkedList;

class GfG {

	static LinkedList<Integer> myQ = new LinkedList<Integer>();

	public void DFS(int v, LinkedList<Integer> adj[], boolean visited[]) {
		if (!visited[v]) {
			visited[v] = true;
			System.out.print(v + " ");
			if (adj[v] != null) {
//				System.out.println();
//				System.out.print("pushed ");
				for (int i = adj[v].size()-1; i >-1 ; i--) {
					if (!visited[adj[v].get(i)]) {
//						System.out.print(" "+adj[v].get(i));						
						myQ.addLast(adj[v].get(i));
					}
				}
//				System.out.println();
				if (!myQ.isEmpty()) {
					v = myQ.pollLast();
//					System.out.println("polled "+v);
					DFS(v, adj, visited);
				}
			} else {
				if (!myQ.isEmpty()) {
					v = myQ.pollLast();
//					System.out.println("polled "+v);
					DFS(v, adj, visited);
				}
			}
		} else {
			if (!myQ.isEmpty()) {
				v = myQ.pollLast();
//				System.out.println("polled "+v);
				DFS(v, adj, visited);
			}
		}
	}
	public void bfs(int v, ArrayList<Integer> adj[], boolean visited[]) {
		if (!visited[v]) {
			visited[v] = true;
			System.out.print(v + " ");
			if (adj[v] != null) {
//				System.out.println();
//				System.out.print("pushed ");
				for (int i = 0; i <adj[v].size() ; i++) {
					if (!visited[adj[v].get(i)]) {
//						System.out.print(" "+adj[v].get(i));						
						myQ.addLast(adj[v].get(i));
					}
				}
//				System.out.println();
				if (!myQ.isEmpty()) {
					v = myQ.pollFirst();
//					System.out.println("polled "+v);
					bfs(v, adj, visited);
				}
			} else {
				if (!myQ.isEmpty()) {
					v = myQ.pollFirst();
//					System.out.println("polled "+v);
					bfs(v, adj, visited);
				}
			}
		} else {
			if (!myQ.isEmpty()) {
				v = myQ.pollFirst();
//				System.out.println("polled "+v);
				bfs(v, adj, visited);
			}
		}
	}
}