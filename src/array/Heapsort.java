package array;

public class Heapsort {
	public static void main(String[] args) {
		int[] A = { 5, 4, 6, 8, 2, 3 };
		heapSort(A);
	}

	public static void heapSort(int[] a) {
		int start = 0;
		int end = a.length - 1;
//		System.out.print("a :: ");
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
//		}
//		System.out.println();
		while (end > start) {
			System.out.print("a :: ");
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			heapify(a, end);			
			int temp = a[end];
			a[end] = a[start];
			a[start] = temp;
			end--;
		}
		System.out.print("a :: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void heapify(int[] a, int end) {
		for (int i = end; i > 0; i--) {
			int parentIndex = 0;
			if (i % 2 == 0) {
				parentIndex = (i - 2) / 2;
			} else {
				parentIndex = (i - 1) / 2;
			}
			if (a[i] < a[parentIndex]) {
				int temp = a[i];
				a[i] = a[parentIndex];
				a[parentIndex] = temp;
			}
		}
	}
}
