package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SubsetOrdered {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(15);
		list.add(20);
		list.add(12);
		list.add(19);
		list.add(4);
		ArrayList<ArrayList<Integer>> res = new SubsetOrdered().subsets(list);
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	Comparator<ArrayList<Integer>> c = new Comparator<ArrayList<Integer>>() {
		@Override
		public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
			// returns 1 if o1 is bigger -1 if o2 bigger 0 if equal
//			System.out.print("o1 = [");
//			for (int i = 0; i < o1.size(); i++) {
//				System.out.print(o1.get(i) + " ");
//			}
//			System.out.print("] :: o2 = [");
//			for (int i = 0; i < o2.size(); i++) {
//				System.out.print(o2.get(i) + " ");
//			}
			int size = Math.min(o1.size(), o2.size());
			for (int i = 0; i < size; i++) {
				if (o1.get(i) > o2.get(i)) {
//					System.out.println("] ==> o1");
					return 1;
				} else if (o1.get(i) < o2.get(i)) {
//					System.out.println("] ==> o2");
					return -1;
				}
			}
			if (o1.size() > o2.size()) {
//				System.out.println("] ==> o1");
				return 1;
			} else if (o1.size() < o2.size()) {
//				System.out.println("] ==> o2");
				return -1;
			} else {
//				System.out.println("] ==> 0");
				return 0;
			}

		}
	};

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		if (A.isEmpty()) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			result.add(temp);
			return result;
		} else {
			int[] arr = new int[A.size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = A.get(i);
			}
			Arrays.sort(arr);
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			result = recursive(arr, 0, result);

			Collections.sort(result, c);
			return result;
		}
	}

	public static ArrayList<ArrayList<Integer>> recursive(int[] A, int index, ArrayList<ArrayList<Integer>> result) {
//		 System.out.println("index = " + index);
		if (index < A.length) {
			int size = result.size();
			if (size > 0) {
				// System.out.println("if");
				for (int i = size - 1; i >= 0; i--) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.addAll(result.get(i));
					temp.add(A[index]);
					result.add(temp);
				}
			} else {
				// System.out.println("else");
				ArrayList<Integer> temp = new ArrayList<Integer>();
				ArrayList<Integer> temp2 = new ArrayList<Integer>();
				temp.add(A[index]);
				result.add(temp2);
				result.add(temp);
			}

			recursive(A, index + 1, result);
		} else {
//			 System.out.println("end");
		}
		return result;
	}

}
