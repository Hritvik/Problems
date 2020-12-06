import java.util.HashMap;
import java.util.Scanner;

public class SnakeAndLadder {
	private static HashMap<Integer, Integer> ladders = null;
	private static HashMap<Integer, Integer> snakes = null;
	private static int minCount = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		while (T-- > 0) {
			minCount = Integer.MAX_VALUE;
			int N = Integer.parseInt(sc.nextLine());
			String[] temp = sc.nextLine().split(" ");
			ladders = new HashMap<Integer, Integer>();
			snakes = new HashMap<Integer, Integer>();
			for (int i = 0; i < 2 * N - 1; i = i + 2) {
				int x = Integer.parseInt(temp[i]);
				int y = Integer.parseInt(temp[i + 1]);
				if (x > y) {
					snakes.put(x, y);
				} else {
					ladders.put(x, y);
				}
			}
//			System.out.println("ladders :: " + ladders);
//			System.out.println("snakes :: " + snakes);
			solver(1, 0);
			System.out.println(minCount);
		}
		sc.close();
	}

	private static void solver(int start, int count) {
//		System.out.println("|" + start + "|");
		if (start <= 30 && count < minCount) {
			if (start == 30) {
				if (minCount > count) {
					minCount = count;
				}
			} else {
				int i = 1;
				while (i <= 6) {
					if (!snakes.containsKey(start + i)) {
						if (ladders.containsKey(start + i)) {
							solver(ladders.get(start + i), count + 1);
						} else {
							solver(start + i, count + 1);
						}
					}
					i++;
				}

			}
		}
	}

}
