package array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MergeWithoutExtraSpaceShellSort {
	private static int arr1[] = null;
	private static int arr2[] = null;

	public static void main(String[] args) {
		
		int T = 0;
		int X = 0;
		int Y = 0;
		String stringArray[] = null;
		String temp_line = null;
		InputStream is = null;
		BufferedReader br = null;
		try {
			is = new FileInputStream("MERGE/0.txt");
//			is = System.in;
			br = new BufferedReader(new InputStreamReader(is));
			StringBuffer sb = new StringBuffer();
			T = Integer.parseInt(br.readLine());
			while (T != 0) {
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				X = Integer.parseInt(stringArray[0]);
				Y = Integer.parseInt(stringArray[1]);
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				arr1 = new int[X];
				for (int i = 0; i < X; i++) {
					arr1[i] = Integer.parseInt(stringArray[i]);
				}
				temp_line = br.readLine();
				stringArray = temp_line.split(" ");
				arr2 = new int[Y];
				for (int i = 0; i < Y; i++) {
					arr2[i] = Integer.parseInt(stringArray[i]);
				}
				shellSorter();
				for (int i = 0; i < arr1.length; i++) {
					sb.append(arr1[i] + " ");
				}
				for (int i = 0; i < arr2.length; i++) {
					sb.append(arr2[i] + " ");
				}
				if (T != 1) {
					sb.append("\n");
				}

				T--;
			}
			System.out.println(sb);
//			long endTime = System.currentTimeMillis();
//			long duration = (endTime - startTime) / 1000;
//			System.out.println("duration = " + duration);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				is.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	private static void printArrays() {
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.print("|");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
	}

	private static void shellSorter() {
		int[] gap = new int[5];
		
	}

}
