package array;

import java.util.ArrayList;

public class NextPermutation {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
//		int[] A = { 444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788,
//				609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84,
//				460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265,
//				315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422,
//				363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52 };
//		int[] A = { 251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149,
//				344, 101, 42, 891, 991 };
		int[] A = { 626, 436, 819, 100, 382, 173, 817, 581, 220, 95, 814, 660, 397, 852, 15, 532, 564, 715, 179, 872,
				236, 790, 223, 379, 83, 924, 454, 846, 742, 730, 689, 112, 110, 516, 85, 149, 228, 202, 988, 212, 69,
				602, 887, 445, 327, 527, 347, 906, 54, 460, 517, 376, 395, 494, 827, 448, 919, 799, 133, 879, 709, 184,
				812, 514, 976, 700, 156, 568, 453, 267, 547, 8, 951, 326, 652, 772, 213, 714, 706, 972, 318, 768, 506,
				59, 854, 422 };
		for (int i = 0; i < A.length; i++) {
			a.add(A[i]);
		}
//		System.out.println(a.get(93));
//		reverse(a, 90, 93);
//		for (int i = 0; i < a.size(); i++) {
//			System.out.print(a.get(i) + " ");
//		}
//		System.exit(0);
		nextPermutation(a);
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
	}

	public static void nextPermutation(ArrayList<Integer> a) {
		boolean breakFlag = false;
		for (int i = a.size() - 1; i > 0; i--) {
			if (a.get(i) > a.get(i - 1)) {
				breakFlag = true;
				int x = i;
				while ((x < a.size()) && (a.get(x) > a.get(i - 1))) {
					x++;
				}
				if (x == a.size()) {
					System.out.println("y");
					swap(a, i - 1, x - 1);
				} else {
					System.out.println("x");
					swap(a, i - 1, x - 1);
				}
				reverse(a, i, a.size() - 1);
				break;
			}
		}
		if (!breakFlag) {
			for (int i = 0; i < a.size(); i++) {
				int j = a.size() - 1;
				if (j > i) {
					swap(a, i, j);
				} else {
					break;
				}
			}
		}
	}

	private static void swap(ArrayList<Integer> a, int x, int y) {
//		System.out.println("to swap :: " + x + " : " + a.get(x) + " & " + y + " : " + a.get(y));
		a.add(x, a.get(y));
		a.remove(y + 1);
		a.add(y + 1, a.get(x + 1));
		a.remove(x + 1);
	}

	private static void reverse(ArrayList<Integer> a, int x, int y) {
//		System.out.println("to reverse :: " + x + " : " + a.get(x) + " & " + y + " : " + a.get(y));
		int i = 0;
		while (x + i < y - i) {
			swap(a, x + i, y - i);
			i++;
		}
	}
}
