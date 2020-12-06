package UGLY;

import java.util.ArrayList;
import java.util.Scanner;

public class UglyNumbers3 {
	private static ArrayList<Long> list = new ArrayList<Long>();
	private static int N = 0;

	public static void main(String[] args) {

		int T = 0;
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		try {
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb = new StringBuffer();
			T = 1;
			while (T != 0) {
				list.clear();
				N = 8;
				System.out.println("N = " + N);
				solver(1, 0, 1, false);

				if (T != 1) {
					sb.append("\n");
				}

				T--;
			}
			System.out.println(sb);
			long endTime = System.currentTimeMillis();
			long duration = (endTime - startTime);
			System.out.println("duration = " + duration);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}

	}

	private static int solver(long num, int th, long prevLevelMax, boolean wasPrevBranchright) {
		int[] set = { 2, 3, 5 };
		for (int i = th; i < set.length; i++) {
			long temp = num * set[i];
			insertSorted(temp);
			if (temp > prevLevelMax && list.size() > N) {
				System.out.println("answer = " + list.get(N));
				break;
			} else {
				if (wasPrevBranchright && i == 2) {// at right most branch
					solver(temp, i, temp, wasPrevBranchright);
				} else {
					if (wasPrevBranchright && (i < 2)) {
						solver(temp, i, prevLevelMax, !wasPrevBranchright);
					} else {
						if (!wasPrevBranchright) {
							solver(temp, i, prevLevelMax, wasPrevBranchright);
						} else {
							System.out.println("unknown case");
						}
					}
				}
			}
		}
		return 0;
	}

	
	public static void insertSorted(long key) {
		System.out.println("key = " + key);
		System.out.print("unsorted set :: ");
		for (int z = 0; z < list.size(); z++) {
			System.out.print(list.get(z) + " ");
		}
		System.out.println();
		int i;
		for (i = list.size() - 1; (i >= 0 && list.get(i) > key); i--) {
		}
		list.add(i + 1, key);

		System.out.print("sorted set :: ");
		for (int z = 0; z < list.size(); z++) {
			System.out.print(list.get(z) + " ");
		}
		System.out.println();
	}
}
