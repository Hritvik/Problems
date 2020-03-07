package QueensAttackHackerRank;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;

public class attempt1_done {
	public static boolean isolated = false;

//TEST CASE 3 :: 308369
	static int queensAttack(int n, int k, int r_q, int c_q, HashSet<String> obstacleSet) {
		boolean d1 = true;
		boolean d2 = true;
		boolean d3 = true;
		boolean d4 = true;
		boolean d5 = true;
		boolean d6 = true;
		boolean d7 = true;
		boolean d8 = true;

		int step = 1;
		int count = 0;
		while (d1 || d2 || d3 || d4 || d5 || d6 || d7 || d8) {
//			System.out.println("step = " + step);
			if (d1) {
				if ((c_q + step < n + 1)) {
					if (obstacleSet.contains(r_q + " " + (c_q + step))) {
						d1 = false;
					} else {
//						System.out.println("R");
						count++;
					}
				} else {
					d1 = false;
//					System.out.println("R end");
				}
			}
			if (d2) {

				if (c_q - step > 0) {
					if (obstacleSet.contains(r_q + " " + (c_q - step))) {
						d2 = false;
					} else {
//						System.out.println("L");
						count++;
					}
				} else {
//					System.out.println("L end");
					d2 = false;
				}
			}
			if (d3) {
				if (r_q + step < n + 1) {
					if (obstacleSet.contains((r_q + step) + " " + (c_q))) {
						d3 = false;
					} else {
						count++;
//						System.out.println("U");
					}

				} else {
					d3 = false;
//					System.out.println("U end");
				}
			}
			if (d4) {
				if (r_q - step > 0) {
					if (obstacleSet.contains((r_q - step) + " " + (c_q))) {
						d4 = false;
					} else {
						count++;
//						System.out.println("D");
					}
				} else {
					d4 = false;
//					System.out.println("D end");
				}
			}
			if (d5) {
				if ((r_q + step < n + 1) && (c_q + step < n + 1)) {
					if (obstacleSet.contains((r_q + step) + " " + (c_q + step))) {
						d5 = false;
					} else {
						count++;
//						System.out.println("UR");
					}
				} else {
					d5 = false;
//					System.out.println("UR end");
				}
			}
			if (d6) {
				if ((r_q - step > 0) && (c_q - step > 0)) {
					if (obstacleSet.contains((r_q - step) + " " + (c_q - step))) {
						d6 = false;
					} else {
						count++;
//						System.out.println("DL");
					}
				} else {
					d6 = false;
//					System.out.println("DL end");
				}
			}
			if (d7) {
				if ((r_q + step < n + 1) && (c_q - step > 0)) {
					if (obstacleSet.contains((r_q + step) + " " + (c_q - step))) {
						d7 = false;
					} else {
						count++;
//						System.out.println("UL");
					}
				} else {
					d7 = false;
//					System.out.println("UL end");
				}
			}
			if (d8) {
				if ((r_q - step > 0) && (c_q + step < n + 1)) {
					if (obstacleSet.contains((r_q - step) + " " + (c_q + step))) {
						d8 = false;
					} else {
						count++;
//						System.out.println("DR");
					}
				} else {
					d8 = false;
//					System.out.println("DR end");
				}
			}
			step++;
		}

		System.out.println("count = " + count);
		return count;

	}

	public static void main(String[] args) throws IOException {
		FileWriter os = null;
		InputStream is = null;
		if (!isolated) {
			os = new FileWriter(System.getenv("OUTPUT_PATH"));
			is = System.in;
		} else {
			is = new FileInputStream("QueensAttackHackerRank/3.txt");
//			is = System.in;
			os = new FileWriter("QueensAttackHackerRank/output.txt");
		}
		BufferedWriter bufferedWriter = new BufferedWriter(os);
//		

		Scanner scanner = new Scanner(is);
		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		String[] r_qC_q = scanner.nextLine().split(" ");

		int r_q = Integer.parseInt(r_qC_q[0]);

		int c_q = Integer.parseInt(r_qC_q[1]);

		int[][] obstacles = new int[k][2];
		HashSet<String> obstacleSet = new HashSet<String>();
		for (int i = 0; i < k; i++) {
			String temp = scanner.nextLine();
//			String[] obstaclesRowItems = temp.split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			obstacleSet.add(temp);
//			for (int j = 0; j < 2; j++) {
//				int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
//				obstacles[i][j] = obstaclesItem;
//			}
		}
		int result = queensAttack(n, k, r_q, c_q, obstacleSet);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
