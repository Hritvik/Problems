package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class mergeSortNumber {
	public static void main(String[] args) {
		int T = 0;
		int N = 0;
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		String stringArray[] = null;
		String temp_line = null;
		// ArrayList<Long> intArray = new ArrayList<Long>();
		int intArray[] = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb = new StringBuffer();
			T = Integer.parseInt(br.readLine());
			while (T != 0) {
				temp_line = br.readLine();
				N = Integer.parseInt(temp_line);
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				intArray = new int[N];
				for (int i = 0; i < stringArray.length; i++) {
					intArray[i] = Integer.parseInt(stringArray[i]);
				}
				// for (int i = 0; i < intArray.length; i++) {
				// System.out.print(intArray[i] + " ");
				// }

				mergeSortMethod(intArray, 0, intArray.length - 1);
				for (int i = 0; i < intArray.length; i++) {
//					System.out.print(intArray[i] + " ");
					sb.append(intArray[i] + " ");
				}
				if (T != 1) {
					sb.append("\n");
				}

				T--;
			}
			System.out.println(sb);
			long endTime = System.currentTimeMillis();
			long duration = (endTime - startTime) / 1000;
//			System.out.println("duration = " + duration);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}

	public static void main1(String[] args) {
		int[] temp = { 1, 4, 3 };
		mergeSortMethod(temp, 0, temp.length - 1);
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]);
		}
		System.out.println();
	}

	private static void mergeSortMethod(int[] intArray, int startIndex, int endIndex) {
		try {

			int middleIndex = (startIndex + endIndex) / 2;
			if (endIndex == startIndex + 1) {
				swapper(intArray, startIndex, endIndex);
			} else {

				// System.out.println("middleIndex = " + middleIndex);
				if (startIndex < middleIndex) {
					mergeSortMethod(intArray, startIndex, middleIndex);
				}
				if (middleIndex + 1 < endIndex) {
					mergeSortMethod(intArray, middleIndex + 1, endIndex);
				}
				arrayMerger(intArray, startIndex, endIndex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void arrayMerger(int[] intArray, int startIndex, int endIndex) {

		int i = startIndex;
		int middleIndex = (startIndex + endIndex) / 2;
		int j = middleIndex + 1;

		int newArray[] = new int[endIndex - startIndex + 1];
//		System.out.println("input");
//		for (int k = startIndex; k <= endIndex; k++) {
//			System.out.print(intArray[k] + " ");
//		}
//		System.out.println();
//		System.out.println("w = " + i + ", " + j);

		for (int k = 0; k < newArray.length; k++) {
//			System.out.println("i=" + i + " middleIndex=" + middleIndex + " j=" + j + " endIndex=" + endIndex);
			if ((i <= middleIndex) && (j <= endIndex)) {
//				System.out.println("choices = " + intArray[i] + ", " + intArray[j]);
				if (intArray[i] >= intArray[j]) {
//					System.out.println(">");
					newArray[k] = intArray[j++];
				} else {
//					System.out.println("<");
					newArray[k] = intArray[i++];
				}
			} else {
				if (i <= middleIndex) {
					newArray[k] = intArray[i++];
				}
				if (j <= endIndex) {
					newArray[k] = intArray[j++];
				}
			}
//			System.out.println("selected = " + newArray[k]);
		}
		for (int k = 0; k < newArray.length; k++) {
			intArray[startIndex + k] = newArray[k];
		}
//		System.out.println("output");
//		for (int k = startIndex; k <= endIndex; k++) {
//			System.out.print(intArray[k] + " ");
//		}
//		System.out.println();
	}

	private static void swapper(int[] intArray, int startIndex, int endIndex) {
		int temp = intArray[startIndex];
		if (intArray[startIndex] > intArray[endIndex]) {
			intArray[startIndex] = intArray[endIndex];
			intArray[endIndex] = temp;
		}
	}
}
