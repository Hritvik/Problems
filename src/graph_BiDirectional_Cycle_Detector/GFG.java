package graph_BiDirectional_Cycle_Detector;

import java.util.LinkedList;

class GfG {
	LinkedList<Integer> myQ = new LinkedList<Integer>();

	public boolean hasCycle(int v, LinkedList<Integer>[] alist, boolean[] visited, boolean[] explored) {
		if (v == 0) {
			return false;
		}
		visited[v - 1] = true;
		System.out.print("v = " + (v - 1));
		for (int i = 0; i < alist[v - 1].size(); i++) {
			if (myQ.peekLast() != alist[v - 1].get(i)) {
				
				System.out.print(" :: push " + alist[v - 1].get(i));
				
				myQ.addLast(alist[v - 1].get(i));
			}
		}
		System.out.println();
		if (alist[v - 1].size()!=0) {
			explored[v-1] = true;
			System.out.println("explr " + (v-1));
		}
		else {
			// connected graph finished
			System.out.println("changing graph component");
			for (int i = 0; i < explored.length; i++) {
				explored[i] = false;
			}
		}
		while (!myQ.isEmpty()) {
			v = myQ.pollLast();
			System.out.println("poll " + v);
			if (v < visited.length) {
				
				if (!visited[v]) {
					// !visited
					
					return hasCycle(v + 1, alist, visited, explored);
				} else {
					if (explored[v]) {
						// visited explored
						System.out.println("Cycle found at :: " + v);
						return true;
					} else {
						// visited !explored
						// go to next
					}
				}
			} else {
				System.out.println("v = " + v + " length = " + visited.length);
			}
		}
		// connected graph finished
		System.out.println("changing graph component");
		for (int i = 0; i < explored.length; i++) {
			explored[i] = false;
		}
		// explored array cleared
		for (int i = alist.length - 1; i > -1; i--) {
			if (!visited[i]) {
				// !visited
				// System.out.println("y " +i);
//				explored[i] = true;
				return hasCycle(i + 1, alist, visited, explored);
			} else {
				if (explored[i]) {
					// visited explored
					// go to next
				} else {
					// visited !explored
					// go to next
				}
			}
		}
		return false;

	}
}