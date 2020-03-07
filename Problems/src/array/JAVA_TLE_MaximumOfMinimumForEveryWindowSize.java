package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JAVA_TLE_MaximumOfMinimumForEveryWindowSize {
	public static void main(String[] args) {
		int T = 0;
		int N = 0;
		String stringArray[] = null;
		String temp_line = null;
		int intArray[] = null;
		BufferedReader br = null;
		try {
			StringBuffer sb = new StringBuffer();
			 br = new BufferedReader(new InputStreamReader(System.in));
			T = Integer.parseInt(br.readLine());
			while (T != 0) {
				temp_line = br.readLine();
				N = Integer.parseInt(temp_line);
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				intArray = new int[stringArray.length];
				for (int i = 0; i < stringArray.length; i++) {
					intArray[i] = Integer.parseInt(stringArray[i]);
				}
				arraySolver(intArray, N, sb);				
				T--;
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void arraySolver(int[] intArray, int K, StringBuffer sb) {

		int temp = 0;
		for (int i = 1; i <= K; i++) {
			temp = maxSolver(intArray, i);
			sb.append(temp + " ");
		}
		sb.append("\n");

	}

	private static int maxSolver(int[] intArray, int windowSize) {
		int Max = 0;
		int temp = 0;
		for (int i = 0; i < intArray.length; i++) {
			if (i + windowSize <= intArray.length) {
				temp = minSolver(intArray, i, windowSize);
				if (temp > Max) {
					Max = temp;
				}
			}
		}
//		System.out.println("WindowSize = " + windowSize + " Max = " + Max);
		return Max;
	}

	private static int minSolver(int[] intArray, int startIndex, int windowSize) {
		int Min = 1000000;
		int temp = 0;
//		System.out.println("input");
//		for (int i = startIndex; i < startIndex + windowSize; i++) {
//			if (i<intArray.length) {
//				System.out.print(intArray[i] + " ");
//			}
//		}
//		System.out.println();
		for (int i = startIndex; i < startIndex + windowSize; i++) {

			if (i < intArray.length) {
				temp = intArray[i];
				if (temp < Min) {
					Min = temp;
				}
			} else {
				break;
			}
		}
//		System.out.println("Min = " + Min);
		return Min;
	}

}
