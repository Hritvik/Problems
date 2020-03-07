package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder_solved {
	public static void main(String[] args) {
		String A = "hit";
		String B = "cog";
		ArrayList<String> C = new ArrayList<String>();
		C.add("hot");
		C.add("dot");
		C.add("dog");
		C.add("lot");
		C.add("log");
		System.out.println(solve(A, B, C));
	}

	public static int solve(String A, String B, ArrayList<String> C) {
		C.add(A);
		C.add(B);
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		for (String key : C) {
			addToGraph(graph, key);
		}

//		for (String key : graph.keySet()) {
//			ArrayList<String> temp = graph.get(key);
//			System.out.print(key + " :: ");
//			for (int i = 0; i < temp.size(); i++) {
//				System.out.print(temp.get(i) + " ");
//			}
//			System.out.println();
//		}

		return findPath(A, B, graph);

	}

	private static int findPath(String a, String b, HashMap<String, ArrayList<String>> graph) {
		Queue<String> q = new LinkedList<String>();
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		HashMap<String, Integer> distance = new HashMap<String, Integer>();
		q.add(a);
		for (String key : graph.keySet()) {
			distance.put(key, Integer.MAX_VALUE);
		}
		distance.put(a, 1);
		while (!q.isEmpty()) {
			String key = q.poll();
			if (!(visited.containsKey(key) && visited.get(key))) {
				visited.put(key, true);
				if (key.equals(b)) {
					return distance.get(b);
				} else {
					ArrayList<String> neighbours = graph.get(key);
					for (String neighbour : neighbours) {
						if (distance.get(neighbour) > distance.get(key) + 1) {
							distance.put(neighbour, distance.get(key) + 1);
						}
						q.add(neighbour);
					}
				}

			}
		}
		return 0;
	}

	private static void addToGraph(HashMap<String, ArrayList<String>> graph, String str) {
		graph.put(str, new ArrayList<String>());
		for (String key : graph.keySet()) {
			if (checkNeighbour(key, str)) {
				ArrayList<String> temp = graph.get(key);
				temp.add(str);
				graph.put(key, temp);
				temp = graph.get(str);
				temp.add(key);
				graph.put(str, temp);
			}
		}
	}

	private static boolean checkNeighbour(String A, String B) {
		int counter = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				counter++;
			}
		}
		if (counter == 1) {
			return true;
		} else {
			return false;
		}
	}
}
