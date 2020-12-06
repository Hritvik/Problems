package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {
	// testcase 18 :: correct 3
	HashMap<Integer, Integer> distance = new HashMap<Integer, Integer>();
	Comparator<Integer> comparator = new myComparator();

	public static void main(String[] args) {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			int T = Integer.parseInt(br.readLine());
			StringBuffer sb = new StringBuffer();
			Dijkstra dijkstra3 = new Dijkstra();
			dijkstra3.findShortestPath(1000);
			while (T-- > 0) {
				int n = Integer.parseInt(br.readLine());
				sb.append(dijkstra3.distance.get(n));
				if (T > 0) {
					sb.append("\n");
				}
			}
			System.out.println(sb);
			br.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main1(String[] args) {
		int n = 10;
		Dijkstra dijkstra3 = new Dijkstra();
		PriorityQueue<Integer> unvisited = new PriorityQueue<Integer>(n, dijkstra3.comparator);
		unvisited.offer(1);
		dijkstra3.distance.put(1, 0);
		for (int i = 2; i <= n; i++) {
			dijkstra3.distance.put(i, n);
			unvisited.offer(i);
		}
		dijkstra3.distance.put(2, 1);
		dijkstra3.distance.put(3, 1);
		for (int i = 2; i <= n; i++) {
			System.out.println(unvisited.poll());
		}
	}

	public void findShortestPath(int n) {
		PriorityQueue<Integer> unvisited = new PriorityQueue<Integer>(n, comparator);
		distance.put(1, 0);
		unvisited.offer(1);
		for (int i = 2; i <= n; i++) {
			distance.put(i, n+i);
			unvisited.offer(i);
		}
//		System.out.print("univisted :: ");
//		for (int t : unvisited) {
//			System.out.print(t + "[" + distance.get(t) + "] ");
//		}
//		System.out.println();
		int minDistanceKey = -1;
		Object temp = unvisited.poll();
		if (temp != null) {
			minDistanceKey = (int) temp;
		}
//		System.out.println("min = " + minDistanceKey);
		while (minDistanceKey != -1 && distance.get(minDistanceKey) != n) {
			if ((distance.containsKey(minDistanceKey + 1))
					&& distance.get(minDistanceKey) + 1 < distance.get(minDistanceKey + 1)) {
				distance.put(minDistanceKey + 1, distance.get(minDistanceKey) + 1);
//				System.out.println((minDistanceKey + 1) + " :: " + (distance.get(minDistanceKey) + 1));
			}
			if ((distance.containsKey(3 * minDistanceKey))
					&& distance.get(minDistanceKey) + 1 < distance.get(3 * minDistanceKey)) {
				distance.put(3 * minDistanceKey, distance.get(minDistanceKey) + 1);
//				System.out.println((3 * minDistanceKey) + " :: " + (distance.get(minDistanceKey) + 1));
			}
			
//			System.out.print("univisted :: ");
//			for (int t : unvisited) {
//				System.out.print(t + "[" + distance.get(t) + "] ");
//			}
//			System.out.println();
			minDistanceKey = -1;
			temp = unvisited.poll();
			if (temp != null) {
				minDistanceKey = (int) temp;
			}
//			System.out.println("min = " + minDistanceKey);
		}

//		for (int key : distance.keySet()) {
//			System.out.println(key + " :: " + distance.get(key));
//		}
	}

	class myComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer a, Integer b) {
			int result = distance.get(a) - distance.get(b);
//			System.out.println("comparing " + a + "[" + distance.get(a) + "], " + b + "[" + distance.get(b)
//					+ "] :: result = " + result);
			return result;
		}

	}

}