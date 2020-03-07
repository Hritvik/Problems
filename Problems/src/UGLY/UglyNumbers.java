package UGLY;

import java.util.ArrayList;
import java.util.Scanner;

public class UglyNumbers {

	private static int N = 0;
	private static int[][][] memory = null;
	private static ArrayList<Integer> A = new ArrayList<Integer>();

	public static void main(String[] args) {

		int T = 0;
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		try {
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb = new StringBuffer();
//			T = Integers.parseInt(br.readLine());
			T = 1;
			while (T != 0) {
//				N = Integer.parseInt(br.readLine());
				N = 7;
				memory = new int[N][N][N];
				A.add(1);
				A.add(2);
				A.add(3);
				A.add(5);
				System.out.print("arr = ");
				for (int i = 0; i < A.size(); i++) {
					System.out.print(A.get(i) + " ");
				}
				System.out.println();
				System.out.println("N = " + N);
				solver(N);
				sb.append("\n");
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

	private static int solver(int N) {
		recursive(0, 0, 0);

		return A.get(N - 1);
	}

	private static void recursive(int i, int j, int k) {
		if (memory[i][j][k] != 0) {
			int x = A.get(i) * A.get(j) * A.get(k);

		}
	}

	private static void insert(int value) {
		for (int i = A.size(); i > 0; i--) {
			if (A.get(i - 1) < value) {
				A.add(i, value);
				break;
			} else {
				if (i == 1) {
					A.add(i - 1, value);
				}
			}
		}
	}
}
