package array;

import java.util.ArrayList;

public class AntiDiagonalofAMatrix_Solved {

	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> B) {
		int[][] A = new int[B.size()][B.size()];
		for (int i = 0; i < B.size(); i++) {
			for (int j = 0; j < B.size(); j++) {
				A[i][j] = B.get(i).get(j);
			}
		}
		int[][] arr = new int[A.length * 2 - 1][A.length];
		for (int i = 0; i < A.length; i++) {
			arr[i] = travel(A, 0, i, i + 1);
		}
		for (int i = 1; i < A.length; i++) {
			arr[A.length - 1 + i] = travel(A, i, A.length - 1, A.length - i);
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < arr[i].length; j++) {
				temp.add(arr[i][j]);
			}
			result.add(temp);
		}
		return result;
	}

	public static int[] travel(int[][] A, int x, int y, int size) {
		int[] diag = new int[size];
		int m = 0;
		while (x < A.length && y > -1) {
			int temp = A[x++][y--];
//            System.out.print(" x :: " + temp);
			diag[m++] = temp;
		}
//        System.out.println();
		return diag;
	}

}
