package array;

import java.util.*;

class CelebrityProblem_Solved {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					M[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Celebrity().getId(M, N));
			t--;
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */

class Celebrity {
	// The task is to complete this function
	int getId(int M[][], int n) {
		int i = 0;
		int k = 1;
		while (i < M.length) {
			System.out.println("**********************");
			boolean breakFlag = false;
			boolean isCelebrity = true;
			for (int j = k; j < M[i].length; j++) {
				System.out
						.println("i = " + i + " :: j = " + j + " :: M[i][j] = " + M[i][j] + " :: M[j][i] = " + M[j][i]);
				if(M[i][j] == 1 || M[j][i] == 0) {
					isCelebrity = false;
				}
				if (M[i][j] == 1 && M[j][i] == 0) {//found prospective celebrity
					i = j;
					k = j + 1;
					breakFlag = true;
					break;
				}
			}
			if (isCelebrity) {
				return i;
			}
			if(!breakFlag) {
				return -1;
			}
		}
		return -1;
	}
}
