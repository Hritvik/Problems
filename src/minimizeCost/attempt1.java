package minimizeCost;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class attempt1 {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			InputStream is = null;
			long startTime = System.currentTimeMillis();
			is = new FileInputStream("MINIMIZE_COST/4.txt");
//			is = System.in;
			scanner = new Scanner(is);
			String[] temp = scanner.nextLine().split(" ");

			int N = Integer.parseInt(temp[0]);

			int K = Integer.parseInt(temp[1]);
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] array = new int[N];
			String[] items = scanner.nextLine().split(" ");
			scanner.close();
			for (int i = 0; i < N; i++) {
				int item = Integer.parseInt(items[i]);
				array[i] = item;
			}
			System.out.println(solver(K, array));
//			long endTime = System.currentTimeMillis();
//			long duration = (endTime - startTime);
//			System.out.println("duration = " + duration);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static long solver(long k, int[] array) {
		int i = 0;
		boolean nextIFlag = false;
		boolean nextJFlag = false;
		boolean lookingForNextIFlag = true;
		int nextI = 0;
		int nextJ = 0;
		int N = array.length;
		int[] t = new int[N];
		while (i < array.length) {
//			System.out.println("i = " + i);
			int j = 1;
			if (nextJFlag) {
				j = nextJ;
			}
			while ((i + j < array.length) && (j <= k)) {
//				System.out.println("i = " + i + " :: j = " + j);
//				printArrays(array, t);
				if ((array[i + j] + t[i + j]) < 0) {
					if ((array[i] + t[i]) > -(array[i + j] + t[i + j])) {
//						System.out.println("+>-");
						t[i] += array[i + j] + t[i + j];
						t[i + j] += -(array[i + j] + t[i + j]);
					} else {
//						System.out.println("+<-");
						t[i + j] += array[i] + t[i];
						t[i] += -(array[i] + t[i]);
						// next j
						nextJ = j-1;
						nextJFlag = true;
						break;
					}

				} else {
					if ((array[i + j] + t[i + j]) > 0) {
//						System.out.println("+ found " + array[i + j] + " lookingForI?" + lookingForNextIFlag);
						if (lookingForNextIFlag) {
							nextI = i + j;
//							System.out.println("nextI = " + nextI);
							nextIFlag = true;
							lookingForNextIFlag = false;
						}

					}
				}
//				System.out.println("nextJFlag = " + nextJFlag);
				if (nextJFlag) {
					j = nextJ;
					if (j <= k) {
						nextJFlag = false;
					}
				} else {
					j++;
				}
			}
//			System.out.println("nextIFlag = " + nextIFlag);
			if (nextIFlag) {
				i = nextI;
				nextIFlag = false;
			} else {
				i = i + j + 1;
			}
			lookingForNextIFlag = true;
		}
		long cost = 0;
		for (int j = 0; j < array.length; j++) {
//			System.out.print("|" + array[j] + " " + t[j] + "| ");
			cost += Math.abs(array[j] + t[j]);
		}
		return cost;
	}

	private static void printArrays(int[] array, int[] t) {
		for (int j = 0; j < array.length; j++) {
			System.out.print("|" + array[j] + " " + t[j] + "| ");
		}
		System.out.println();
	}
}
