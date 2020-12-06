import java.util.ArrayList;
import java.util.Arrays;

public class subSets {
	public static void main(String[] args) {
		int[] A = { 12, 13 };
		subsets(A);
	}

	public static int[][] subsets(int[] A) {
		Arrays.sort(A);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = recursive(A, 0, result);
		int[][] res = new int[result.size()][];
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> tempList = result.get(i);
			int[] temp = new int[tempList.size()];
			for (int j = 0; j < tempList.size(); j++) {
				temp[j] = tempList.get(j);
			}
			res[i] = temp;
		}
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
		return res;
	}

	public static ArrayList<ArrayList<Integer>> recursive(int[] A, int index, ArrayList<ArrayList<Integer>> result) {
		System.out.println("index = " + index);
		if (index < A.length) {
			int size = result.size();
			if (size > 0) {
				System.out.println("if");
				for (int i = 0; i < size; i++) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.addAll(result.get(i));
					temp.add(A[index]);
					result.add(temp);
				}
			} else {
				System.out.println("else");
				ArrayList<Integer> temp = new ArrayList<Integer>();
				ArrayList<Integer> temp2 = new ArrayList<Integer>();
				temp.add(A[index]);
				result.add(temp2);
				result.add(temp);
			}

			recursive(A, index + 1, result);
		} else {
			System.out.println("end");
		}
		return result;
	}

}
