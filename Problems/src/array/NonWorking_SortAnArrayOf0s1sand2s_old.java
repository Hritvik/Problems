package array;
/*package whatever //do not write package name here */

import java.util.*;

class NonWorking_SortAnArrayOf0s1sand2s_old {
	public static void main(String[] args) {
		int T = 0;
		int N = 0;

		Scanner in = new Scanner(System.in);
		String stringArray[] = null;
		String temp_line = null;
		// ArrayList<Long> intArray = new ArrayList<Long>();
		int intArray[] = null;
		try {
			T = Integer.parseInt(in.nextLine());
			while (T != 0) {
				temp_line = in.nextLine();
				N = Integer.parseInt(temp_line);
				temp_line = in.nextLine();
				stringArray = temp_line.split(" ");
				intArray = new int[N];
				for (int i = 0; i < stringArray.length; i++) {
					intArray[i] = Integer.parseInt(stringArray[i]);
				}
				// for (int i = 0; i < intArray.length; i++) {
				// System.out.print(intArray[i] + " ");
				// }
				mergeSort(intArray, 0, intArray.length - 1);
				for (int i = 0; i < intArray.length; i++) {
					System.out.print(intArray[i] + " ");
				}
				System.out.println();
				T--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}

	private static void mergeSort(int[] intArray, int startIndex, int endIndex) {
		try {

			int middleIndex = (startIndex + endIndex) / 2;
			if (endIndex == startIndex + 1) {
				swapper(intArray, startIndex, endIndex);
			} else {

				// System.out.println("middleIndex = " + middleIndex);
				if (startIndex < middleIndex) {
					mergeSort(intArray, startIndex, middleIndex);
				}
				if (middleIndex + 1 < endIndex) {
					mergeSort(intArray, middleIndex + 1, endIndex);
				}
				arrayMerger(intArray, startIndex, endIndex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void arrayMerger(int[] intArray, int startIndex, int endIndex) {
		int i = startIndex;
		int j = endIndex / 2 + 1;
		int k = 0;
		int newArray[] = new int[endIndex - startIndex + 1];
		while (i <= endIndex / 2 && j <= endIndex) {
			if (intArray[i] > intArray[j]) {
				newArray[k++] = intArray[j++];
			} else {
				newArray[k++] = intArray[i++];
			}
		}
		while ((i <= endIndex / 2) && (k < newArray.length) && (i < intArray.length)) {
			newArray[k++] = intArray[i++];
		}
		while ((j <= endIndex) && (k < newArray.length) && (j < intArray.length)) {
			newArray[k++] = intArray[j++];
		}
		for (int l = 0; l < newArray.length; l++) {
			intArray[startIndex + l] = newArray[l];
		}
	}

	private static void swapper(int[] intArray, int startIndex, int endIndex) {
		int temp = intArray[startIndex];
		if (intArray[startIndex] > intArray[endIndex]) {
			intArray[startIndex] = intArray[endIndex];
			intArray[endIndex] = temp;
		}
	}
}