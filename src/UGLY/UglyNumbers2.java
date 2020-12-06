package UGLY;

import java.util.ArrayList;
import java.util.Scanner;

public class UglyNumbers2 {
	private static ArrayList<Integer> orderedSet = new ArrayList<Integer>();
	private static int N = 0;

	public static void main(String[] args) {

		int T = 0;
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		try {
			StringBuffer sb = new StringBuffer();
//			T = Integers.parseInt(br.readLine());
			T = 1;
			while (T != 0) {
//				N = Integer.parseInt(br.readLine());
				N = 7;
				System.out.println("N = " + N);
				orderedSet.clear();
				orderedSet.add(1);
				orderedSet.add(2);
				orderedSet.add(3);
				orderedSet.add(5);
				solver(0, 0, 0);
				sb.append(orderedSet.get(orderedSet.size() - 1) + "\n");
				if (T != 1) {
					sb.append("\n");
				}

				T--;
			}
			System.out.println(sb);
			long endTime = System.currentTimeMillis();
			long duration = (endTime - startTime) / 1000;
			System.out.println("duration = " + duration);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}

	}

	private static int solver(int i, int j, int k) {
		System.out.println("params :: i = " + i + " :: j = " + j + " :: k = " + k);
		System.out.println("value at :: i = " + orderedSet.get(i) + " :: j = " + orderedSet.get(j) + " :: k = "
				+ orderedSet.get(k));
		if (orderedSet.size() < 100) {
			int a = 999999999;
			int b = 999999999;
			int c = 999999999;
			if ((i + 1 < orderedSet.size())
			/*
			 * && (!orderedSet.contains(orderedSet.get(i + 1) * orderedSet.get(j) *
			 * orderedSet.get(k)))
			 */) {
				a = orderedSet.get(i + 1) * orderedSet.get(j) * orderedSet.get(k);
				if (orderedSet.contains(a)) {
					a = 999999999;
				}
			}
			if ((j + 1 < orderedSet.size())
			/*
			 * && (!orderedSet.contains(orderedSet.get(i) * orderedSet.get(j + 1) *
			 * orderedSet.get(k)))
			 */) {
				b = orderedSet.get(i) * orderedSet.get(j + 1) * orderedSet.get(k);
				if (orderedSet.contains(b)) {
					b = 999999999;
				}
			}
			if ((k + 1 < orderedSet.size())
			/*
			 * && (!orderedSet.contains(orderedSet.get(i) * orderedSet.get(j) *
			 * orderedSet.get(k + 1)))
			 */) {
				c = orderedSet.get(i) * orderedSet.get(j) * orderedSet.get(k + 1);
				if (orderedSet.contains(c)) {
					c = 999999999;
				}
			}

			int min = min(a, b, c);
			if (min != 999999999) {
				System.out.println(" :: min = " + min);
				insertSorted(min);
			} else {
				System.out.println();
			}
			if (min == a) {
				System.out.println("i++");
				i++;
			} else {
				if (min == b) {
					System.out.println("j++");
					j++;
				} else {
					if (min == c) {
						System.out.println("k++");
						k++;
					}
				}
			}
			System.out.print("set :: ");
			for (int z = 0; z < orderedSet.size(); z++) {
				System.out.print(orderedSet.get(z) + " ");
			}
			System.out.println();

			solver(i, j, k);

			return 0;

		} else {
			return orderedSet.get(N - 1);
		}
	}

	private static int min(int a, int b, int c) {
		System.out.print("a = " + a + " b = " + b + " c = " + c);
		return Integer.min(Integer.min(a, b), c);
	}

//	public static void insertionSort() {
//		int n = orderedSet.size();
//		for (int j = 1; j < n; j++) {
//			int key = orderedSet.get(j);
//			int i = j - 1;
//			while ((i > -1) && (orderedSet.get(i) > key)) {
//				orderedSet.add(i + 1, orderedSet.get(i));
//				i--;
//			}
//			orderedSet.add(i + 1, key);
//		}
//	}

	public static void insertSorted(int key) {
//		System.out.println("key = " + key);
//		System.out.print("unsorted set :: ");
//		for (int z = 0; z < orderedSet.size(); z++) {
//			System.out.print(orderedSet.get(z) + " ");
//		}
//		System.out.println();

		int i;
		for (i = orderedSet.size() - 1; (i >= 0 && orderedSet.get(i) > key); i--) {
		}
		orderedSet.add(i + 1, key);

//		System.out.print("sorted set :: ");
//		for (int z = 0; z < orderedSet.size(); z++) {
//			System.out.print(orderedSet.get(z) + " ");
//		}
//		System.out.println();
	}
}
