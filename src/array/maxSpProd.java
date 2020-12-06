package array;

import java.util.HashMap;
import java.util.Iterator;

public class maxSpProd {
	public static void main(String[] args) {
//		int[] A = { 2, 4, 1, 11, 5, 23, 3, 14, 9, 10 };
//		System.out.print("in :: ");
//		for (int i = 0; i < A.length; i++) {
//			System.out.print(A[i] + " ");
//		}
//		System.out.println();
		int[] A = { 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 };
		System.out.println(maxSpecialProduct(A));
	}

	public static long maxSpecialProduct(int[] A) {
		HashMap<String, Boolean> rCurr = new HashMap<String, Boolean>();
		HashMap<String, Boolean> lCurr = new HashMap<String, Boolean>();
		int[] rJ = new int[A.length];
		int[] lJ = new int[A.length];
		int j = 0;
		Iterator<String> itr = null;
		for (int i = 0; i < A.length; i++) {
			rCurr.put(i + "_" + A[i], true);
			itr = rCurr.keySet().iterator();
			while (itr.hasNext()) {
				String r = itr.next();
				if (rCurr.get(r)) {
					String[] temp = r.split("_");
					int value = Integer.parseInt(temp[1]);
					int index = Integer.parseInt(temp[0]);
					System.out.println("r :: is " + A[i] + " > " + value);
					if (A[i] > value) {
						System.out.println("r yes");
						rCurr.remove(index + "_" + value);
						rJ[index] = i;
					}

				}
			}
			j = A.length - i - 1;
			lCurr.put(j + "_" + A[j], true);
			itr = lCurr.keySet().iterator();
			while (itr.hasNext()) {
				String l = itr.next();
				if (lCurr.get(l)) {
					String[] temp = l.split("_");
					int value = Integer.parseInt(temp[1]);
					int index = Integer.parseInt(temp[0]);
					System.out.println("l :: " + A[j] + " " + value);
					if (A[j] > value) {
						System.out.println("l found");
						lCurr.remove(index + "_" + value);
						lJ[index] = j;
					}

				}
			}
//			System.out.println("------------------------");
		}
//		System.out.print("rJ :: ");
//		for (int i = 0; i < A.length; i++) {
//			System.out.print(rJ[i] + " ");
//		}
//		System.out.println();
//		System.out.print("lJ :: ");
//		for (int i = 0; i < A.length; i++) {
//			System.out.print(lJ[i] + " ");
//		}
//		System.out.println();
		int max = 0;
		for (int i = 0; i < A.length; i++) {
//			System.out.println(i + " :: " + rJ[i] * lJ[i]);
			if (max < rJ[i] * lJ[i]) {
				max = rJ[i] * lJ[i];
			}
		}
		return max;
	}
}
