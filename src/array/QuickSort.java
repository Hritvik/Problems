package array;

public class QuickSort {
	public static void main(String[] args) {
//		int A[] = { 9, 8, 7, 6, 5, 4, 3 };
//		int A[] = { 3, 4, 5, 6, 7, 8, 9 };
//		int A[] = { 4, 3, 12, 5, 7, 8, 0, 19 };
//		int A[] = { 119, 160, 390, 947, 604, 251 };
//		int A[] = {	411, 575, 686, 364, 887, 183};
		int A[] = { 4, 1, 3, 9, 7 };
		System.out.print("unsorted array :: ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		quicksort(A, 0, A.length - 1);
		System.out.print("sorted array :: ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	public static void quicksort(int[] a, int start, int end) {
		if (start < end) {
			int pi = partition(a, start, end);
			System.out.println("pi = " + pi);
			quicksort(a, start, pi - 1);
			quicksort(a, pi + 1, end);
		}
	}

	private static int partition(int[] a, int start, int end) {
		System.out.println("partition :: start = " + start + " :: end = " + end);
		int pivotIndex = end;
		int i = start - 1;
		int j = end;
		int[] prev = { i, j };
		while (i < j) {
			System.out.println("i  " + i + " :: j = " + j + " :: pi = " + pivotIndex);
			prev[0] = i;
			prev[1] = j;
			int[] temp = null;
			temp = findNextPair(a, i + 1, j - 1, a[pivotIndex]);
			i = temp[0];
			j = temp[1];
			if (i != -1 && j != -1) {
				if (i < j) {
					swap(a, i, j);
				} else {
					pivotIndex = i;
					break;
				}

			} else if (i == -1 && j != -1) {
				pivotIndex = j + 1;
				break;
			} else if (i != -1 && j == -1) {
				pivotIndex = i;
				break;
			} else {
				System.out.println("unknown");
				pivotIndex = prev[0]+1;
			}
		}
		swap(a, pivotIndex, end);
		System.out.print("array :: ");
		for (int x = 0; x < a.length; x++) {
			System.out.print(a[x] + " ");
		}
		System.out.println();
		return pivotIndex;
	}

	public static int[] findNextPair(int[] a, int start, int end, int pivot) {
		int[] temp = { -1, -1 };
		for (int i = start; i <= end; i++) {
			System.out.println("i :: " + a[i] + " [" + i + "] vs " + pivot + " :: end = " + end);
			if (a[i] > pivot && i <= end) {
				temp[0] = i;
				break;
			}
		}
		for (int i = end; i >= start; i--) {
			System.out.println("j :: " + a[i] + " [" + i + "] vs " + pivot + " :: start = " + start);
			if (a[i] < pivot && i >= start) {
				temp[1] = i;
				break;
			}
		}
		System.out.println("found :: " + temp[0] + ", " + temp[1]);
		return temp;
	}

	private static void swap(int[] a, int i, int j) {
		if (i != j) {
			System.out.println("swapped " + a[i] + "[" + i + "] & " + a[j] + "[" + j + "]");
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

}
