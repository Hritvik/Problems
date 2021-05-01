package foobar;

public class GrandestStaircase {
	public static void main(String[] args) {
		System.out.println(solution(200));
	}

	public static int solution(int n) {
		return recursive(n, 1) - 1;
	}

	private static int recursive(int total_bricks, int min_h) {
		int count = 0;
		for (int bricks_used = min_h; bricks_used <= total_bricks; bricks_used++) {
			int remaining_bricks = total_bricks - bricks_used;
			int next_min_h = bricks_used + 1;
			if (remaining_bricks >= next_min_h) {
				count += recursive(remaining_bricks, next_min_h);
			} else if (remaining_bricks == 0) {
				count++;
			} else {
				bricks_used += remaining_bricks - 1;
			}
		}
		return count;
	}
}
