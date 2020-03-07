package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
2
28
83
55 61 51 75 17 22 4 13 39 28 77 49 46 91 14 67 88 62 25 37 69 38 59 62 48 88 100 53 
96 16 34 53 88 6 50 26 76 10 8 4 37 18 73 54 30 31 97 2 28 24 2 30 79 77 33 86 
16
98
20 16 45 73 99 87 38 53 99 99 38 65 22 17 17 51 
31 21 78 53 18 66 61 4 11 65 16 99 87 91 44 23
Output of Online Judge is:
474
356
*/
public class knapsack_dp {
	static int[][] memory;
	static int N;
	static int W;
	static int[] w;
	static int[] v;

	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		try {
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				N = Integer.parseInt(br.readLine());
				int W = Integer.parseInt(br.readLine());
				memory = new int[W][N];
				for (int i = 0; i < W; i++) {
					for (int j = 0; j < N; j++) {
						memory[i][j] = -1;
					}
				}
				String[] temp = br.readLine().split(" ");
				v = new int[N];
				for (int i = 0; i < N; i++) {
					v[i] = Integer.parseInt(temp[i]);
				}
				temp = br.readLine().split(" ");
				w = new int[N];
				for (int i = 0; i < N; i++) {
					w[i] = Integer.parseInt(temp[i]);
				}
				int result = solve(W, 0);
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static int solve(int W, int i) {
		if (W > 0) {
			if (memory[W - 1][i] != -1) {
//				System.out.println("[" + W + ", " + i + "] return from memory :: " + memory[W - 1][i]);
				return memory[W - 1][i];
			} else {

				if (i == N - 1) {
					if (w[i] < W) {
						memory[W - 1][i] = v[i];
						return v[i];
					} else {
						memory[W - 1][i] = 0;
						return 0;
					}
				} else {
					int without = solve(W, i + 1);
					int with = 0;
					if (W > w[i]) {
						with = v[i] + solve(W - w[i], i + 1);
					}

					if (with > without) {
//						System.out.println("[" + W + ", " + i + "] :: with = " + with);
						memory[W - 1][i] = with;
						return with;
					} else {
//						System.out.println("[" + W + ", " + i + "] :: without = " + without);
						memory[W - 1][i] = without;
						return without;
					}
				}

			}
		} else {
			return 0;
		}
	}

	static int recursive(int weight, int i) {
		if (weight < W) {
			if (memory[weight][i] != -1) {
				return memory[weight][i];
			} else if (i == N - 1) {
				System.out.println("dfgfd");
				if (weight + w[i] < W) {
					memory[weight][i] = v[i];
					return v[i];
				} else {
					memory[weight][i] = 0;
					return 0;
				}
			} else {
				int with = v[i] + recursive(weight + w[i], i + 1);
				int without = recursive(weight, i + 1);
				System.out.println("[" + weight + ", " + i + "] :: with = " + with + " :: without = " + without);
				if (with > without) {
					memory[weight][i] = with;
					return with;
				} else {
					memory[weight][i] = without;
					return without;
				}
			}

		} else {
			return 0;
		}
	}
}
