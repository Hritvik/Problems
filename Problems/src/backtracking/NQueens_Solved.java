package backtracking;

import java.util.ArrayList;

public class NQueens_Solved {
	public static void main(String[] args) {
		(new NQueens_Solved()).solveNQueens(8);
	}

	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < a; i++) {
			ArrayList<String> row = new ArrayList<String>();
			for (int j = 0; j < a; j++) {
				row.add(".");
			}
			matrix.add(row);
		}
		ArrayList<ArrayList<String>> resultMatrices = new ArrayList<ArrayList<String>>();
		placeQueens(matrix, a, 0, resultMatrices);
		for (int i = 0; i < resultMatrices.size(); i++) {
			System.out.println("---------" + (i + 1) + "---------");
			for (int j = 0; j < resultMatrices.get(i).size(); j++) {
				System.out.println(resultMatrices.get(i).get(j));
			}
		}
		return resultMatrices;
	}

	int placeQueens(ArrayList<ArrayList<String>> matrix, int no_of_rows, int row_for_q,
			ArrayList<ArrayList<String>> result_matrices_list) {
		int Nth_Q_PLACED = 1;
		if (row_for_q == no_of_rows) {
			return Nth_Q_PLACED;
		} else {
//			System.out.println("recursive :: " + I);
//			for (int i = 0; i < matrix.size(); i++) {
//				for (int j = 0; j < matrix.get(i).size(); j++) {
//					System.out.print(matrix.get(i).get(j) + " ");
//				}
//				System.out.println();
//			}
			for (int column_for_q = 0; column_for_q < no_of_rows; column_for_q++) {
				if (queenSafe(matrix, row_for_q, column_for_q)) {
					matrix.get(row_for_q).remove(column_for_q);
					matrix.get(row_for_q).add(column_for_q, "Q");
					int result_of_placing_remaining_queens = placeQueens(matrix, no_of_rows, row_for_q + 1,
							result_matrices_list);
					if (result_of_placing_remaining_queens == Nth_Q_PLACED) {
						ArrayList<String> result_matrix = new ArrayList<String>();
						for (int x = 0; x < matrix.size(); x++) {
							String tempStr = "";
							for (int j = 0; j < matrix.get(x).size(); j++) {
								tempStr += matrix.get(x).get(j);
							}
							result_matrix.add(tempStr);
						}
						result_matrices_list.add(result_matrix);
					}
					// moving on from this placement of current Q
					matrix.get(row_for_q).remove(column_for_q);
					matrix.get(row_for_q).add(column_for_q, ".");
				}
			}
			return 0;
		}
	}

	boolean queenSafe(ArrayList<ArrayList<String>> matrix, int x, int y) {
//		System.out.println("x = " + x + " :: y = " + y);
		int l = 0;
		for (int i = x - 1; i > -1; i--) {
			if (matrix.get(i).get(y).equals("Q")) {
				return false;
			}
			if ((y - 1 - l > -1) && matrix.get(i).get(y - 1 - l).equals("Q")) {
				return false;
			}
			if ((y + 1 + l < matrix.size()) && matrix.get(i).get(y + 1 + l).equals("Q")) {
				return false;
			}
			l++;
		}
		return true;
	}

}
