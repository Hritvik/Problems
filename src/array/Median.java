package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Median {
	public static void main(String[] args) {
		int T = 0;
		int N = 0;
		int X = 0;
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		String stringArray[] = null;
		String temp_line = null;
		int intArray[] = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb = new StringBuffer();
			T = Integer.parseInt(br.readLine());
			while (T != 0) {
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				N = Integer.parseInt(stringArray[0]);
				X = Integer.parseInt(stringArray[1]);
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				intArray = new int[N];
				for (int i = 0; i < stringArray.length; i++) {
					intArray[i] = Integer.parseInt(stringArray[i]);
				}

				sb.append(solver(N, X, intArray));
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

	public static void main1(String[] args) {
		int[] A = { 10, 20, 30, 100, 150, 200 };
		solver(6, 30, A);
//		int[] A = { 10, 20, 30, 100, 150 };
//		solver(5, 50, A);
	}

	private static int solver(int N, int X, int[] A) {
		int count = 1;
		int currMean = 0;
		int i = 0;
		if (A.length % 2 == 0) {// even
			currMean = (A[N / 2] + A[(N / 2) - 1]) / 2;
			i = (N / 2) - 1;
			if (X > currMean) {
				i = i + 1;
				while (A[i] < X) {
					i++;
					count++;
				}
			} else {
				while (A[i] < X) {
					i--;
					count++;
				}
			}
		} else {
			currMean = A[(N - 1) / 2];
			i = ((N - 1) / 2);
			if (X > currMean) {
				i = i + 1;
				while (A[i] < X) {
					i++;
					count++;
				}
			} else {
				i = i - 1;
				while (A[i] < X) {
					i--;
					count++;
				}
			}
		}

		return count;

	}
}
