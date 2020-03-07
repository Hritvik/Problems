package array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MergeWithoutExtraSpace_TLE {
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
				solver3();
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

	private static void solver1() {
		int i = 0;
		boolean flag = true;
		int j = 0;
		while (i < arr1.length) {
			j = 0;
			flag = true;
			while (j < arr2.length) {
				printArrays();
				System.out.println("i = " + i + ", j = " + j);
				if (flag) {
//					System.out.println(arr1[i] + "  " + arr2[j]);
					if (arr1[i] > arr2[j]) {
						arr1[i] = arr1[i] + arr2[j];
						arr2[j] = arr1[i] - arr2[j];
						arr1[i] = arr1[i] - arr2[j];
						flag = false;
					} else {
						break;
					}
				} else {
//					System.out.println(arr2[j] + "  " + arr2[j - 1]);
					if (arr2[j] < arr2[j - 1]) {
						arr2[j] = arr2[j] + arr2[j - 1];
						arr2[j - 1] = arr2[j] - arr2[j - 1];
						arr2[j] = arr2[j] - arr2[j - 1];
					} else {
						break;
					}
				}
				j++;
			}
//			System.out.println("\n---");
			i++;
		}

	}

	private static void solver2() {
		int x = 0;
		int y = 0;
		while (x < arr1.length) {
			printArrays();
			System.out.println(x + " " + y);
			if (arr1[x] > arr2[y]) {
				arr1[x] = arr1[x] + arr2[y];
				arr2[y] = arr1[x] - arr2[y];
				arr1[x] = arr1[x] - arr2[y];
				while ((y + 1 < arr2.length) && (arr2[y + 1] < arr2[y])) {
					printArrays();
					System.out.println(x + " " + y);
					arr2[y + 1] = arr2[y + 1] + arr2[y];
					arr2[y] = arr2[y + 1] - arr2[y];
					arr2[y + 1] = arr2[y + 1] - arr2[y];
					y++;
				}
				y = 0;
			} else {
				x++;
			}
		}
	}

	private static void solver3() {
		boolean flag = true;
		while (flag) {
			flag = false;
			int temp = 0;
			int temp1 = 0;
			for (int j = 0; j < arr1.length; j++) {
//				printArrays();
//				System.out.println("j = " + j);
				if (flag) {
					temp1 = arr1[j];
					arr1[j] = temp;
					temp = temp1;
				} else {
					if (arr1[j] > arr2[0]) {
						flag = true;
						temp = arr1[j];
						arr1[j] = arr2[0];
					}
				}
			}
			if (flag) {
				int j = 0;
				arr2[j] = temp;
				j++;
				while ((j < arr2.length) && (arr2[j] < arr2[j - 1])) {
//					printArrays();
//					System.out.println("j = " + j);
//					temp1 = arr2[j];
					temp = arr2[j];
					arr2[j] = arr2[j - 1];
					arr2[j - 1] = temp;
					j++;
				}
			}
		}

	}
}
