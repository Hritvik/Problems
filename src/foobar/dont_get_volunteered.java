package foobar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class dont_get_volunteered {
	public static void main(String[] args) {
		System.out.println(dont_get_volunteered.solution(0, 1));

	}

	public static int solution(int src, int dest) {
		int src_x = src / 8;
		int src_y = src % 8;
		int dest_x = dest / 8;
		int dest_y = dest % 8;
		int[][] dist = new int[8][8];
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[src_x][src_y] = 0;
		Queue<int[]> Q = new ArrayDeque<>();
		Q.add(new int[] { src_x, src_y });
		while (!Q.isEmpty()) {
			print(dist);
			int[] pos = Q.poll();
			List<int[]> neighbours = findNeighbours(pos[0], pos[1]);
			for (int[] neighbour : neighbours) {
				if (dist[neighbour[0]][neighbour[1]] > (1 + dist[pos[0]][pos[1]])) {
					dist[neighbour[0]][neighbour[1]] = (1 + dist[pos[0]][pos[1]]);
					Q.add(neighbour);
				}
			}
		}
		return dist[dest_x][dest_y];
	}

	private static void print(int[][] dist) {
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {
				System.out.print(((dist[i][j] == Integer.MAX_VALUE) ? "-" : dist[i][j]) + " ");
			}
			System.out.println();
		}
	}

	private static List<int[]> findNeighbours(int x, int y) {
		List<int[]> positions = new ArrayList<>();
		if (x + 2 < 8 && y + 1 < 8) {
			positions.add(new int[] { x + 2, y + 1 });
		}
		if (x + 2 < 8 && y - 1 >= 0) {
			positions.add(new int[] { x + 2, y - 1 });
		}
		if (x - 2 >= 0 && y + 1 < 8) {
			positions.add(new int[] { x - 2, y + 1 });
		}
		if (x - 2 >= 0 && y - 1 >= 0) {
			positions.add(new int[] { x - 2, y - 1 });
		}

		if (x + 1 < 8 && y + 2 < 8) {
			positions.add(new int[] { x + 1, y + 2 });
		}
		if (x + 1 < 8 && y - 2 >= 0) {
			positions.add(new int[] { x + 1, y - 2 });
		}
		if (x - 1 >= 0 && y + 2 < 8) {
			positions.add(new int[] { x - 1, y + 2 });
		}
		if (x - 1 >= 0 && y - 2 >= 0) {
			positions.add(new int[] { x - 1, y - 2 });
		}
		return positions;
	}
}
